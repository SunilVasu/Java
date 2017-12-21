package ctci;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by sunil on 10/31/17.
 */

//Recursive
public class DFS_graph {
    private int V;
    private LinkedList<Integer> adj[];

    DFS_graph(int v){
        V=v;
        adj = new LinkedList[v];
        for(int i=0;i<v;i++)
            adj[i]=new LinkedList<>();
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }

    void DFSUtil(int v, boolean visited[]){
        visited[v]=true;
        System.out.print(v+" ");

        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext()){
            int n=i.next();
            if(!visited[n])
                DFSUtil(n,visited);
        }
    }

    void DFS(int v){
        boolean visited[] = new boolean[V];
        DFSUtil(v,visited);
    }
    public static void main(String[] args){
        DFS_graph dfs = new DFS_graph(4);

        dfs.addEdge(0,1);
        dfs.addEdge(0,2);
        dfs.addEdge(1,2);
        dfs.addEdge(2,0);
        dfs.addEdge(2,3);
        dfs.addEdge(3,3);

        System.out.println("Following is the DFS (starting from vertex 2)");
        dfs.DFS(2);
    }


}
