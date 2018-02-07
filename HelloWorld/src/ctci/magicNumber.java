package ctci;

import java.util.*;

/**
 * Created by sunil on 12/27/17.
 */
public class magicNumber {
    //find the kth number which is a multiple of 3,5,7
    public static void main(String args[]){
        int k=3;
        List<Integer> arr = calculate(k);
        Collections.sort(arr);
        for(int i=0;i<=k;i++)
            System.out.print(arr.get(i+1)+" ");

        calculate_optimal(k+1);
    }
    //Brute Force
    //iterate and find all values, then sort and find the kth value.
    public static List<Integer> calculate(int k){
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<=k;i++){
            int powA = (int)Math.pow(3,i);
            for(int j=0;j<=k;j++){
                int powB = (int)Math.pow(5,j);
                for(int l=0;l<=k;l++){
                    int powC = (int)Math.pow(7,l);
                    res.add(powA*powB*powC);
                }
            }
        }
        return res;
    }
    //Optimal
    public static void calculate_optimal(int k){
        Queue<Integer> q3 = new LinkedList<>();
        Queue<Integer> q5 = new LinkedList<>();
        Queue<Integer> q7 = new LinkedList<>();

        int val;
        q3.add(1);
        System.out.print("\nOptimal k:\n");
        for(int i=0;i<=k;i++){
            int v3 = q3.size()>0 ? q3.peek(): Integer.MAX_VALUE;
            int v5 = q5.size()>0 ? q5.peek(): Integer.MAX_VALUE;
            int v7 = q7.size()>0 ? q7.peek(): Integer.MAX_VALUE;
            val = Math.min(v3, Math.min(v5, v7));

            if(v3==val){
                q3.remove();
                q3.add(3*val);
                q5.add(5*val);
            }else if(v5==val){
                q5.remove();
                q5.add(5*val);
            }else if(v7==val){
                q7.remove();
            }
            q7.add(7*val);
            System.out.print(val+" ");
        }
    }


}
