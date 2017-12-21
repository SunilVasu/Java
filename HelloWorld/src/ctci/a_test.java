package ctci;

import java.util.Scanner;

/**
 * Created by sunil on 12/16/17.
 */
public class a_test {

    public static void main(String[] args){
        a_test obj = new a_test();

        int[] arr = new int[]{-9,-1,2,-3,0};

        int sum=0, maxSum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(maxSum<sum)
                maxSum=sum;
            else if(sum<0)
                sum=0;
        }

        //System.out.print("\nOutput\tmaxSum::"+maxSum);

        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d = scan.nextDouble();
        scan.nextLine();
        String s = scan.nextLine();
        // Write your code here.

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);

    }


}
