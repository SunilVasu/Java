package ctci;

/**
 * Created by sunil on 1/3/18.
 */
public class array_string {
    public static void main(String[] args){
        compress();
    }
    public static void compress(){
        String str = "aaabbb";
        StringBuilder sb = new StringBuilder();
        int count=0;
        for(int i=0;i<str.length();i++){
            count++;
            if(i+1>=str.length() || str.charAt(i)!=str.charAt(i+1)){
                sb.append(str.charAt(i)).append(count);
                count=0;
            }
        }
        System.out.println("Str:"+sb.toString());
    }
}
