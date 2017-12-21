package ctci;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Arrays;

/**
 * Created by sunil on 11/8/17.
 */
public class peeks_Valleys {
    public static void main(String[] args){
        peeks_Valleys pv = new peeks_Valleys();
        int[] arr = new int[]{0,1,4,7,8,9};

        System.out.print("Input:: ");
        for(int i=0; i<arr.length;i++)
            System.out.print(arr[i]+" ");

        System.out.print("\nSort Result:: ");
        pv.sort(arr);

        System.out.print("\nSort2 Result:: ");
        pv.sort2(arr);
    }
    // Sort method 1::
    //peek_valley generation after sorting the array
    public void sort(int[] arr){
        Arrays.sort(arr);
        for(int i=1;i<arr.length;i+=2)
        {
            int temp = arr[i];
            arr[i] = arr[i-1];
            arr[i-1] = temp;
        }
        for(int i=0; i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }
    // Sprt method 2::
    // peek & valley generation without sort function
    public void sort2(int[] arr){
        for(int i=1; i<arr.length; i+=2){
            int biggestIndex = maxIndex(arr, i-1, i, i+1);
            if(i!=biggestIndex){
                int temp = arr[i];
                arr[i] = arr[biggestIndex];
                arr[biggestIndex] = temp;
            }
        }
        for(int i=0; i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }

    public int maxIndex(int[] arr, int a, int b, int c){
        int len = arr.length;
        int aVal = a>=0 && a<len ? arr[a]: Integer.MIN_VALUE;
        int bVal = b>=0 && b<len ? arr[b]: Integer.MIN_VALUE;
        int cVal = c>=0 && c<len ? arr[c]: Integer.MIN_VALUE;

        int max = Math.max(aVal, Math.max(bVal, cVal));
        if(aVal == max) return a;
        else if(bVal == max) return b;
        else return c;
    }

}
