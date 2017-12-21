package ctci;

import java.util.Scanner;

/**
 * Created by sunil on 12/16/17.
 */
public class a_basic {

    public static void main(String[] args){
        a_basic obj = new a_basic();
        //stdin and stdout
        Scanner scan = new Scanner(System.in);

        int i = scan.nextInt();
        //scan.nextLine();
        double d = scan.nextDouble();
        //scan.nextLine();
        String s = scan.next();


        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);

    }


}
