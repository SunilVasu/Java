import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sunil on 10/25/17.
 */
public class expedia {
    public static void main(String[] args){
    //question1();
    question2();
    question3();
    }

    public static void question1(){
        List<String> res = new ArrayList();
        Scanner in = new Scanner(System.in);
        String[] val = new String[2];
        while(in.hasNextLine()){
            String line = in.nextLine();
            if(line.equals("exit"))
                break;
            val = line.split(",");
            res.add(val[1]);
        }
        StringBuilder sb = new StringBuilder();
        for(String n:res){
            sb.append(n).append(',');
        }
        String out = sb.toString().substring(0,sb.length()-1);
        System.out.println("Question1::"+out);
    }
    public static void question2(){
        String link = "https://google.com/index.html?page=1";
        System.out.println(link);
        String res;
        res = link.replaceAll("://",",");
        //res = link.replaceAll("\/",",");
        res = res.replaceAll("/index.html\\?",",");
        res = res.replaceAll("/index.html",",");
        System.out.println("Question2::"+res);
    }
    public static void question3(){
        int[] coins = new int[]{1,2,3};
        int amount=5;
        int[] dp = new int[amount+1];

        for(int sum=1;sum<=amount;sum++){
            int min=-1;
            for(int coin:coins){
                if(sum>=coin && dp[sum-coin]!=-1){
                    int temp = dp[sum-coin]+1;
                    min = min<0?temp:(temp<min?temp:min);
                }
                dp[sum]=min;
            }
        }
        System.out.println("Question3::Min::"+dp[amount]);
    }
}
