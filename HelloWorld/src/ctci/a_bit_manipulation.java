package ctci;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sunil on 1/10/18.
 */
public class a_bit_manipulation {
    static int var =0;
    public static void main(String[] args){

        conversion();
        swap();
        a_bit_manipulation obj = new a_bit_manipulation();
        obj.test();
    }
    public void test(){
        var++;
        System.out.println("var:"+var);
        int[] in = new int[] {12,3,45,4,3,1};
        int[] out = new int[in.length];
        int p1=0, p2=in.length-1;
        while(p1<p2){
            if(in[p1]%2!=0 && in[p2]%2==0){
                int tmp = in[p1];
                in[p1]=in[p2];
                in[p2]=tmp;
                p1++; p2--;
            }else{
            if(in[p1]%2==0) p1++;
            if(in[p2]%2!=0) p2--;
            }
        }
        for(int n:in)
            System.out.println(n);
    }
    public static void conversion(){
        //function to determine the number of bits you would need to flip to convert integer A --> integer B.
        int a = 0b11101, b=0b01111;
        int count=0;
        for(int c = a^b; c!=0; c=c>>1){
            count += c&1;
        }
        System.out.println("count:"+count);
        //optimalized: c = c & ( c - 1) will clear the least significant bit in c
        //((n&(n-1)) == 0) checks if n is a power of 2 (or if n is 0).
        count=0;
        for(int c=a^b;c!=0; c=c&(c-1)){
            count ++;
        }
        System.out.println("count:"+count);
    }
    public static void swap(){
        int x = 0b10000010;
        x = ((x&0xaaaaaaaa)>>>1)|((x & 0x55555555)<<1);
        System.out.println("After swap:"+Integer.toBinaryString(x));
    }
}
