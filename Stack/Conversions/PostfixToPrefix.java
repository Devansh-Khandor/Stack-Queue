package Stack.Conversions;

import java.util.*;

public class PostfixToPrefix {

    public static void main(String args[]){
        String s = "ABC/-AK/L-*";
        System.out.println(postToPre(s));
    }
    static String postToPre(String str) {
        // code here
        int n = str.length();
        Stack<String> s = new Stack<>();
        for(int i=0;i<n;i++){
            char c = str.charAt(i);
            if((c>='A' && c<='Z') || (c>='a' && c<='z') || (c>='0' && c<='9')){
                s.push(String.valueOf(c));
            }
            else{
                String t1 = s.peek();
                s.pop();
                String t2 = s.peek();
                s.pop();
                String ans = c+t2+t1;
                s.push(ans);
            }
        }
        return s.peek();
    }
}
