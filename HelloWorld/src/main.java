/**
 * Created by sunil on 10/22/17.
 */
public class main {
    public static void main(String[] args){
        String[] exp = new String[] {"<<","<<>","><><"};
        int[] max = new int[]{2,0,0};
        balancedOrNot(exp,max);
        //System.out.println("HelloWorld");
    }

    public static void balancedOrNot(String[] exp , int[] max){
        int[] result= new int[exp.length];
        for(int i=0;i<exp.length;i++){
            char[] ch = exp[i].toCharArray();
            int r=0,l=0,lb=0;
            for(char c:ch){
                if(c=='>' && (r==0||r==l))
                    lb++;
                else if(c=='<')
                    r++;
                else if(c=='>'&& r>0)
                    l++;
            }
            int diff = r-l>0?r-l:l-r;
            if(diff==0 && lb<=max[i])
                result[i]=1;
            else
                result[i]=0;
        System.out.println("i="+i+" result:"+result[i]);
        System.out.println("lb="+lb+" l="+l+" r="+r+"\n");
        }
    }
}


