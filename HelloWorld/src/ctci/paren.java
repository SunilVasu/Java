package ctci;

import java.util.ArrayList;

/**
 * Created by sunil on 11/3/17.
 */
public class paren {
    public static void main(String[] args){
        paren obj = new paren();
        obj.generateParens(3);
    }
    void generateParens(int count){
        char[] str = new char[count*2];
        ArrayList<String> list = new ArrayList<String>();
        addParens(list, count, count, str, 0);
        for(String s: list)
            System.out.println(s);
    }

    void addParens(ArrayList<String> list, int left, int right, char[] str, int index){
        if(left<0 || right<left) return;
        if(left==0 && right==0)
            list.add(String.copyValueOf(str));
        else{
            str[index]='(';
            addParens(list, left-1, right, str, index+1);
            str[index]=')';
            addParens(list, left, right-1, str, index+1);
        }
    }

}
