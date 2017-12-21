package ctci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by sunil on 11/3/17.
 */
public class Hanoi {
    public static void main(String[] args){
        int n=3;
        Tower[] towers = new Tower[n];
        for(int i=0;i<3;i++){
            towers[i]=new Tower(i);
        }
        for(int i=n-1; i>=0; i--)
            towers[0].add(i);

        towers[0].moveDisks(n, towers[2], towers[1]);
    }
}
class Tower{

    Stack<Integer> disk;
    int index;
    public Tower(int i){
        index=i;
        disk = new Stack<Integer>();
    }
    public void add(int d){
        if(!disk.isEmpty() && disk.peek()<=d)
            System.out.println("Error placing disk:"+d);
        else
            disk.push(d);
    }
    public void moveTopTo(Tower t){
        int top = disk.pop();
        t.add(top);
    }
    public void moveDisks(int n, Tower destination, Tower buffer){
        if(n>0){
            moveDisks(n-1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(n-1, destination, this);
        }
    }
}

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        Arrays.sort(nums);
        backtrace(list, new ArrayList(), nums);
        return list;
    }
    public void backtrace(List<List<Integer>> list, List<Integer> tempList, int[] nums){
        if(tempList.size()==nums.length)
            list.add(new ArrayList(tempList));
        else{
            for(int i=0;i<nums.length;i++){
                if(tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backtrace(list, tempList, nums);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}

