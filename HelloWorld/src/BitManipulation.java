/**
 * Created by sunil on 10/28/17.
 */
public class BitManipulation {
    public static void main(String[] args) {

        int x=5;
        int y=((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1);
        System.out.println("Result::"+y);
        System.exit(0);

        int a = 29, b = 15;
        int count = 0;
        /*for (int c = a ^ b; c != 0; c = c & (c - 1)) {
            count++;
        }*/
        for(int c=a^b; c!=0; c=c>>1){
            count+=c&1;
            System.out.println("c:"+c);
            System.out.println("count"+count);
        }
        System.out.println("Final::"+count);
    }
}
