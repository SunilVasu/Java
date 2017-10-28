/**
 * Created by sunil on 10/23/17.
 */
public class subSet {
    public static void main(String[] args){
        String set = "HelloWorld";
        String subSet = "Hel";
        int m=set.length(), n=subSet.length();
        boolean res = cal(set,subSet,m-1,n-1);
        System.out.println(res);
    }

    static boolean cal(String set, String subSet, int m, int n){
        if(n==0)
            return true;
        if(m==0)
            return false;

        if(set.charAt(m)==subSet.charAt(n))
            return cal(set, subSet, m-1, n-1);
        return cal(set, subSet,m-1, n);
    }
}
