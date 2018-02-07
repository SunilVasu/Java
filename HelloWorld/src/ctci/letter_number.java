package ctci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by sunil on 12/24/17.
 */
public class letter_number {
    public static void main(String[] args){
        //char[] input = {'A','A','0','9','6','A','A','A','1','A','3','A','A','2','A','A',};
        char[] input = {'A','0','A','0','A','9','A','A'};
        char[] res={};
        //BruteForce
        outerloop:
        for(int len=input.length;len>1;len--){
            for(int i=0;i<=input.length-len;i++){
                if(hasEqual(input, i, i+len-1))
                {
                    res = subarray(input, i, i+len-1);
                    System.out.print("Here::> i:"+i+"  i+len-1:"+(i+len-1)+" len:"+(input.length-len)+"\n");
                    break outerloop;
                }
            }
        }
        System.out.print(Arrays.toString(res));
        //Optimized
        int[] delta = computeDelta(input);
        int[] match = longestDistance(delta);
        res = subarray(input, match[0]+1, match[1]);
        System.out.print("\n\nOptimized Soln::"+Arrays.toString(res));
    }
    public static boolean hasEqual(char[] input, int start, int end){
        int count=0;
        for(int i=start;i<=end;i++){
            if(Character.isDigit(input[i]))
                count++;
            else if(Character.isLetter(input[i]))
                count--;
        }
        return count==0;
    }
    public static char[] subarray(char[] input, int start, int end){
        char[] subarray=new char[end-start+1];
        for(int i=start;i<=end;i++){
            subarray[i-start]=input[i];
        }
        return subarray;
    }
    public static int[] computeDelta(char[] input){
        int[] delta = new int[input.length];
        for(int i=0;i<input.length;i++){
            if(Character.isDigit(input[i]))
                delta[i]++;
            else if(Character.isLetter(input[i]))
                delta[i]--;
        }
        return delta;
    }
    public static int[] longestDistance(int[] delta){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int[] max = new int[2];
        for(int i=0;i<delta.length;i++){
            if(!map.containsKey(delta[i]))
                map.put(delta[i],i);
            else{
                int match = map.get(delta[i]);
                int distance = i - match;
                int longest = max[1]-max[0];
                if(longest<distance){
                    max[1]=i;
                    max[0]=match;
                }
            }
        }
        return max;
    }


}
