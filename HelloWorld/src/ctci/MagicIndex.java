package ctci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sunil on 11/2/17.
 */
public class MagicIndex {
    public static void main(String[] args) {
        MagicIndex obj = new MagicIndex();

        //Magic Index
        //obj.magic();

        //subset
        List<List<Integer>> list = obj.subsetsWithDup(new int[] {1,2,2});
        for(int i=0; i< list.size();i++){
            {System.out.print("[");
            for(int j=0; j< list.get(i).size(); j++)
                System.out.print(list.get(i).get(j));
            System.out.print("]\t");}
        }

        //System.out.println("::"+a);

        //Recursive Multiply
        System.out.println("\n::"+obj.minProduct(23,2));
    }

    public int minProduct(int a, int b){
        int smaller = a<b? a:b;
        int bigger = a<b? b:a;
        return minProductHelper(smaller, bigger);
    }
    public int minProductHelper(int smaller, int bigger){
        if(smaller<=0) return 0;
        else if(smaller==1) return bigger;

        int s= smaller>>1;
        int halfprod = minProductHelper(s,bigger);
        if(smaller%2==0)
            return halfprod+halfprod;
        else
            return halfprod+halfprod+bigger;
    }

    public void magic(){
        int[] array1 = new int[]{-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        int[] array2 = new int[]{-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};

        System.out.println("Binary Search index:"+ binary(array2, 0, array2.length));
        System.out.println("Magic index:"+ magicIndex(array2, 0, array2.length));
    }

    public int binary(int[] array, int start, int end){
        int mid=(start+end)/2;
        if(end<start)
            return -1;
        if(array[mid]==mid)
            return mid;
        else if(array[mid] < mid)
            return binary(array, mid+1, end);
        else
            return binary(array, start, mid-1);
    }

    public int magicIndex(int[] array, int start, int end){
        if(end<start)
            return -1;

        int mid=(start+end)/2;
        if(mid==array[mid])
            return mid;

        int left = Math.min(mid-1, array[mid]);
        left=magicIndex(array, start, left);
        if(left>=0)
            return left;

        int right = Math.max(mid+1, array[mid]);
        right = magicIndex(array,right, end);
        return right;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        Arrays.sort(nums);
        backtrace(list, new ArrayList(),nums,0);
        return list;
    }
    public void backtrace(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start){
        list.add(new ArrayList(tempList));
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]) continue; //avoid duplicates
            tempList.add(nums[i]);
            backtrace(list, tempList, nums,i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}
