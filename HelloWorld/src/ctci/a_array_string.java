package ctci;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sunil on 1/3/18.
 */
public class a_array_string {
    public static void main(String[] args){
        compress();
        zero_matrix();
        binaryAddition();
        intersection();
        intersection2();
    }
    public static void compress(){
        String str = "aaabbb";
        StringBuilder sb = new StringBuilder();
        int count=0;
        for(int i=0;i<str.length();i++){
            count++;
            if(i+1>=str.length() || str.charAt(i)!=str.charAt(i+1)){
                sb.append(str.charAt(i)).append(count);
                count=0;
            }
        }
        System.out.println("Str:"+sb.toString());
    }
    public static void zero_matrix(){
        int[][] mat = {{1,0,1},{1,2,0},{1,2,3}};
        boolean[] row = new boolean[mat.length];
        boolean[] col = new boolean[mat[0].length];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }
        for(int i=0;i<mat.length;i++){
            if(row[i])
                nullifyRow(mat,i);
        }
        for(int j=0;j<mat.length;j++){
            if(col[j])
                nullifyCol(mat,j);
        }
        //output
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++)
                System.out.print(mat[i][j]+" ");
            System.out.print("\n");
        }
    }
    public static void nullifyRow(int[][] mat, int r){
        for(int i=0;i<mat[0].length;i++){
            mat[r][i]=0;
        }
    }
    public static void nullifyCol(int[][] mat, int c){
        for(int i=0;i<mat.length;i++){
            mat[i][c]=0;
        }
    }
    //Binary addition
    public static void binaryAddition(){
        String a = "1001";
        String b = "101";
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int result, carry=0, i=aArray.length-1, j=bArray.length-1;
        while(i>-1 || j>-1 || carry==1){
            int aByte = i>-1? Character.getNumericValue(aArray[i--]):0;
            int bByte = j>-1? Character.getNumericValue(bArray[j--]):0;
            result = aByte^bByte^carry;
            carry = aByte+bByte+carry>1?1:0;
            sb.append(result);
        }
        System.out.print("Binary Addition:: "+sb.reverse().toString());
    }
    //Intersection of two array
    public static void intersection(){
        int[] num1={1,2,3,4,5};
        int[] num2={9,9,3};
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for(int n:num1)
            set.add(n);
        for(int n:num2)
            if(set.contains(n))
                intersect.add(n);
        int[] res = new int[intersect.size()];
        int i=0;
        for(int n:intersect)
            res[i++]=n;
        System.out.print("\nIntersection::");
        for(int n:res)
            System.out.print(n+" ");
    }
    public static void intersection2(){
        int[] nums1={1,2,3,4,5};
        int[] nums2={9,9,3};
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        int i=0, j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j])
                i++;
            else if(nums1[i]>nums2[j])
                j++;
            else{
                set.add(nums1[i]);
                i++; j++;
            }
        }
        int[] res = new int[set.size()];
        int k=0;
        for(int n:set)
            res[k++]=n;
        System.out.print("\nIntersection2::");
        for(int n:res)
            System.out.print(n+" ");
    }


}
