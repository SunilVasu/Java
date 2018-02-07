package ctci;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunil on 12/27/17.
 */
public class majority {
    public static void main(String[] args){
        //Brute Force
        int[] arr = {1,1,4,3,4,4,1};
        int res=0;
        for(int n:arr){
            int c=0;
            for(int k:arr){
                if(n==k)
                    c++;
            }
            if(c==arr.length/2)
                res=n;
        }
        System.out.print("Majority Number:"+res);

        //Optimal Solution
        int count=0, ans=0;
        for(int n:arr){
            if(count==0)
                ans=n;
            if(n==ans)
                count++;
            else
                count--;
        }
        //verify
        count=0;
        for(int n:arr){
            if(n==ans)
                count++;
        }
        System.out.print("\nOptimal Soln=>\tMajority Number:"+ans +" Status:"+(count==(arr.length/2)));

        //find two majority in arr
        findThreeMajority(arr);
    }

    public static void findThreeMajority(int[] arr){
        int r1=0, c1=0, r2=0, c2=0;
        List<Integer> res = new ArrayList<>();
        for(int n:arr){
            if(n==r1)
                c1++;
            else if(n==r2)
                c2++;
            else if(c1==0)
                r1=n;
            else if(c2==0)
                r2=n;
            else{
                c1--; c2--;
            }
        }
        c1=0; c2=0;
        for(int n:arr){
            if(r1==n)
                c1++;
            if(r2==n)
                c2++;
        }
        if(c1>arr.length/3)
            res.add(r1);
        if(c2>arr.length/3)
            res.add(r2);
        System.out.print("\n2 Majority=>\tResult:");
        for(int n:res)
            System.out.print(n+" ");
    }
}
