package ctci;

/**
 * Created by sunil on 11/24/17.
 */
public class knapsack {
    public static void main(String[] args){
        knapsack ks = new knapsack();

        int[] val = new int[]{60,100,120};
        int[] wt = new int[]{10,20,30};
        int W=50;
        int n = val.length;
        System.out.println("Recursion::"+ks.recursion(W,wt,val,n));

        System.out.println("DP::"+ks.dynamic(W,wt,val,n));
    }
    public int recursion(int W, int[] wt, int[] val, int n){
        if(W==0 || n==0)
            return 0;
        else if(wt[n-1]>W)
            return recursion(W, wt, val, n-1);
        else
            return Math.max(val[n-1]+recursion(W-wt[n-1], wt, val, n-1),
                    recursion(W, wt, val, n-1));
    }
    public int dynamic(int W, int[] wt, int[] val, int n){
        int[][] k = new int[n+1][W+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=W;j++){
                if(i==0||j==0)
                    k[i][j]=0;
                else if(wt[i-1]>j)
                    k[i][j] = k[i-1][j];
                else
                    k[i][j] = Math.max(val[i-1]+k[i-1][j-wt[i-1]], k[i-1][j]);
            }
        }
        return k[n][W];
    }

}