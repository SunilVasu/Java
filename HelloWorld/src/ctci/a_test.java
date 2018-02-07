package ctci;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sunil on 12/16/17.
 */
public class a_test {

    public static void main(String[] args){
        a_test obj = new a_test();

        int[] arr = new int[]{-9,-1,2,-3,0};

/*        int sum=0, maxSum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(maxSum<sum)
                maxSum=sum;
            else if(sum<0)
                sum=0;
        }*/

        //System.out.print("\nOutput\tmaxSum::"+maxSum);
/*
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d = scan.nextDouble();
        scan.nextLine();
        String s = scan.nextLine();
        // Write your code here.

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);*/

        int a=2, b=3,i=0;
        while(b!=0){
            int sum=a^b;
            int carry = (a&b)<<1;
            a=sum;
            b=carry;
            System.out.println((i++)+": "+a+"\t"+b);
        }
        System.out.println(a);

        String str = "b3a";
        char[] ch = str.toCharArray();
        char c = ch[ch.length/2];
        char r =  (char)(2*Character.getNumericValue(c) + '0');
        System.out.println("\nr:"+r);
        ch[ch.length/2] = (char)(2*Character.getNumericValue(c) + '0') ;

        for(char s:ch)
            System.out.print(s);

        String in = "NextCompany";
        String key = "next";

        System.out.println("\nKey:: "+in.toLowerCase().contains(key.toLowerCase()));
        char[] w = in.toCharArray();
        char temp = w[0];
        w[0]=w[3];
        w[3]=temp;
        temp = w[1];
        w[1]=w[2];
        w[2]=temp;

        System.out.println("\nKey::"+ Arrays.toString(w));
    }


}
