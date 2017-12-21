package ctci;

/**
 * Created by sunil on 12/6/17.
 */
public class fibin {
    public static void main(String[] arg){
        fibin f = new fibin();
        int res = f.recur(4);
        System.out.println("Recur::"+res);

        int linear = f.linear(4);
        System.out.println("Linear::"+res);
    }

    public int recur(int n){
        if(n<=1)
            return n;
        else
            return recur(n-1) + recur(n-2);
    }

    public int linear(int n){
        int[] f = new int[n];
        f[0]=0;
        f[1]=1;
        int i=2;
        while(i<n){
            f[i]=f[i-1]+f[i-2];
            i++;
        }
        return f[n-1];
    }
}
