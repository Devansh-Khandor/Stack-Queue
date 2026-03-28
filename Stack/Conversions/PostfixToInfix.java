package Stack.Conversions;

import java.util.*;

public class PostfixToInfix {
    public static void main(String args[]){
        String s = "ab-de+f*/";
        System.out.println(postToInfix(s));
    }

    public static String postToInfix(String str) {
        // code here
        Stack<String> s = new Stack<>();
        int n = str.length();
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
                String ans = '('+t2+c+t1+')';
                s.push(ans);
            }
        }
        return s.peek();
    }
}
