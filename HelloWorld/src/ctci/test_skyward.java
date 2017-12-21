package ctci;

/**
 * Created by sunil on 12/1/17.
 */
public class test_skyward {
    public static void main(String[] args) {

        test_skyward obj = new test_skyward();
        long digits=7;
        obj.find(digits);
    }

    public void find(long digits) {

        long largestPalindromeProduct = -1;
        long startNum = (long)Math.pow(10, digits) - 1;
        long endNum = (long)Math.pow(10, digits-1) - 1;

        for (long i = startNum; i > endNum; i--) {
            for (long j = startNum; j > endNum; j--) {
                if (isPalindrome(i * j)) {
                    largestPalindromeProduct =  Math.max(largestPalindromeProduct, i * j);
                }
            }
        }
        System.out.println("product:"+largestPalindromeProduct);
    }

    private boolean isPalindrome(long number) {
        String s = String.valueOf(number);
        int j = s.length()-1, i=0;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            j--;
            i++;
        }
        return true;
    }
}
