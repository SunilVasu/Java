package ctci;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunil on 12/16/17.
 */
public class Grid {
    public static void main(String[] arg){
        int[][] grid = new int[][]{{0,2,1,0},{0,1,0,1},{1,1,0,1},{0,1,0,1}};
        List<Integer> gridSize = new ArrayList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    int size = computeSize(grid, i,j);
                    gridSize.add(size);
                }
            }
        }
        for(int i:gridSize)
            System.out.println("Size::"+i);
    }
    public static int computeSize(int[][] grid, int r, int c){
        if(r<0 || r>=grid.length || c<0 || c>=grid.length || grid[r][c]!=0)
            return 0;

        int size=1;
        grid[r][c]=-1;
        for(int dr=-1;dr<=1;dr++)
            for(int dc=-1;dc<=1;dc++)
                //if(r!=0 || c!=0)
                size += computeSize(grid,r+dr,c+dc);
        //no diagonal considered
        //size +=  computeSize(grid,r+1,c) + computeSize(grid,r,c+1)+ computeSize(grid,r-1,c)
        //        + computeSize(grid,r,c-1);


        return size;
    }
}
