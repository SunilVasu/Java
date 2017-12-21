package ctci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sunil on 12/14/17.
 */
public class occurance {
    public static void main(String[] args){
        occurance oc = new occurance();
        int[] arr = new int[]{1,1,2,1,1};
        int[] res_arr=oc.check(arr);
        for(int n:res_arr) {
            System.out.print(n + "\n");
        }
    }

    public int[] check(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }

/*        for(int i=0;i<arr.length;i++)
        {
            if(map.get(arr[i])==1)
                res.add(arr[i]);
        }*/
        //How to iterate over Map
        for(Integer n: map.keySet()){
            if(map.get(n)==1)
                res.add(n);
        }
        for(Integer n: map.values()){
            System.out.print(n + "\n");
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int k=entry.getKey();
            int v=entry.getValue();
            if(v==1)
                System.out.print("Numeber:"+k+ "\n");
        }


        int[] res_arr = new int[res.size()];
        int j=0;
        for(int i:res) {
            res_arr[j] = i;
            j++;
        }
        return res_arr;
    }
}
