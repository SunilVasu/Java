package ctci;

/**
 * Created by sunil on 12/28/17.
 */
public class String_examples {
    public static void main(String[] args){
        //reverse String in java
        String s1 = "Hello World";
        String s12 = "Hello";
        String s3 = s1.intern();
        System.out.print("intern(): "+s3);

        StringBuilder sb = new StringBuilder(s1);
        System.out.print("\nReversed: "+sb.reverse().toString());

        //check Palindrome String in java
        s1 = "malayalam";
        String s2 = new String();
        System.out.print("\ns1==s2 "+(s1==s2));
        s2 = new StringBuilder(s1).reverse().toString();
        if(s1.equals(s2))
            System.out.print("\nIs a Palindrome");

        //capitalize each word in string  this is javatpoint --> This Is Javatpoint
        s1 = "this is javatpoint";
        String[] words = s1.split(" ");
        String capitalizedWord="";
        for(String w:words){
            String first = w.substring(0,1);
            String rest = w.substring(1);
            capitalizedWord += first.toUpperCase()+rest+" ";
        }
        System.out.print("\ncapitalizedWord:"+capitalizedWord);

        //reverse each word in string
        s1 = "this is javatpoint";
        String[] words2 = s1.split(" ");
        String capitalizedWord2="";
        for(String w:words2){
            capitalizedWord2 += (new StringBuilder(w).reverse().toString())+" ";
        }
        System.out.print("\nReversedWord:"+capitalizedWord2);

        //to tOGGLE each word in string?
        s1 = "this is javatpoint";
        String[] words3 = s1.split(" ");
        String res ="";
        for(String w: words3){
            String first = w.substring(0,1);
            String rest = w.substring(1).toUpperCase();
            res += first+rest+" ";
        }
        System.out.print("\ntOGGLE Word:"+res);

        //reverse tOGGLE each word in string?
        s1 = "this is javatpoint";
        String[] words4 = s1.split(" ");
        StringBuilder sb1= new StringBuilder();
        for(String w:words4){
            String res2= (new StringBuilder(w).reverse().toString());
            String first = res2.substring(0,1);
            String rest = res2.substring(1).toUpperCase();
            sb1.append(first).append(rest).append(" ");
        }
        System.out.print("\nreverse tOGGLE Word:"+sb1.toString());

        //int to string
        String in="123";
        int n = Integer.parseInt(in);
        int m = Integer.valueOf(in);
        System.out.print("\nn:"+n+" m:"+m);
        in = Integer.toString(m);
        System.out.print("\nto String in:"+in);
        in=String.valueOf(n);
        System.out.print("\nto String in:"+in);

        //count the number of words in a string
        String ip2 = "Hello world to Java!";
        int c=0;
        for(int i=0;i< ip2.length();i++){
            if((i>0 && ip2.charAt(i)!=' ' && ip2.charAt(i-1)==' ')||(i==0 && ip2.charAt(0)!=' '))
                c++;
        }
        System.out.print("\nCount:"+c);
        //to reverse a given string with preserving the position of spaces
        String ip = "Hello world to Java!";
        char[] input = ip.toCharArray();
        char[] res2 = new char[input.length];
        for(int i=0;i<input.length;i++){
            if(input[i]==' ')
                res2[i]=' ';
        }
        int j=res2.length-1;
        for(int i=0;i<input.length;i++){
            if(input[i]!=' '){
                if(res2[j]==' ')
                    j--;
                res2[j]=input[i];
                j--;
            }
        }
        System.out.print("\nReverse String:"+String.valueOf(res2));
        //swap two string variables without using third or temp variable in java
        //Swap string : love you --> you love
        String st1="Love";
        String st2="You";
        st1 = st1+st2;
        st2 = st1.substring(0, st1.length()-st2.length());
        st1 = st1.substring(st2.length());
        System.out.println("\nAfter : " + st1 + " " + st2);

        //remove a particular character (ith index) from a string
        String st="Welcome to Canada";
        int p=0;
        st=st.substring(0,p)+st.substring(p+1);
        System.out.println("\nRemoved : " + st);
    }
}
