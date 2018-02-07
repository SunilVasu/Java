package ctci;

/**
 * Created by sunil on 1/1/18.
 */
public class masseuse {
    public static void main(String[] args){
        int[] massage = new int[] {30,15,60,75,45,15,15,45};
        masseuse obj = new masseuse();
        int res = obj.maxMinutes(massage,0);
        System.out.println("Recursion:"+res);
        obj.iterative(massage);
        obj.optimal(massage);

    }
    //time O(2"), space 0(n)
    public int maxMinutes(int[] massage, int index){
        if(index>=massage.length) return 0;
        int bestWith = massage[index]+maxMinutes(massage,index+2);
        int bestWithout = maxMinutes(massage, index+1);
        return Math.max(bestWith, bestWithout);
    }
    //time 0(n), space 0(n)
    public void iterative(int[] massage){
        int[] memo = new int[massage.length+2];
        memo[massage.length+1]=0;
        memo[massage.length]=0;
        for(int i=massage.length-1;i>=0;i--){
            int bestWith = massage[i]+memo[i+2];
            int bestWithout = memo[i+1];
            memo[i]=Math.max(bestWith,bestWithout);
        }
        System.out.println("Iterative:"+memo[0]);
    }
    //time 0 (n), space O(1)
    public void optimal(int[] massage){
        int twoaway = 0;
        int oneaway = 0;
        for(int i=massage.length-1;i>=0;i--){
            int bestWith = massage[i]+twoaway;
            int bestWithout = oneaway;
            int current = Math.max(bestWith, bestWithout);
            twoaway = oneaway;
            oneaway = current;
        }
        System.out.println("Optimal:"+oneaway);
    }
}
