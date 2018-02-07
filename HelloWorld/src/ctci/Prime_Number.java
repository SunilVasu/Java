package ctci;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.Arrays;


/**
 * Created by sunil on 1/19/18.
 */
public class Prime_Number {
    public static void main(String[] args){
        //print N prime Number
        //print_N_primeNumber(10);
        //find Nth prime Number
        //find_Nth_primeNumber(10);
        //Count num of primeNumber less than N
        //countPrimeLess_N(30);

        //test_db();
    }
    public static void print_N_primeNumber(int n){
        int count=0;
        int i=0;
        while(count<n){
            if(isPrime(i)){
                count++;
                System.out.println(count+") "+i);
            }
            i++;
        }
    }
    public static boolean isPrime(int num){
        if(num<2) return false;
        if(num==2) return true;
        if(num%2==0) return false;
        for(int i=3;i<num/2;i+=2){
            if(num%i==0)
                return false;
        }
        return true;
    }
    //find nth prime number
    public static void find_Nth_primeNumber(int n){
        int count=0;
        int i=0;
        while(count<n){
            if(isPrime(i)){
                count++;
                if(count==n){
                    System.out.println(i+" is the "+n+"th Prime Number");
                    break;
                }
            }
            i++;
        }
    }
    //Count of prime Number less than N
    public static void countPrimeLess_N(int n){
        boolean[] prime = new boolean[n];
        Arrays.fill(prime,true);
        int count=0;
        for(int i=2;i<n;i++){
            if(prime[i]==true){
                count++;
                for(int j=2;j*i<n;j++)
                    prime[j*i]=false;
            }
        }
        System.out.println("There are "+count+" primes less than "+n);
    }

}
