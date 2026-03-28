package Stack.Conversions;

import java.util.*;

public class PrefixToInfix {

    public static void main(String args[]){
        String s = "*-A/BC-/AKL";
        System.out.println(preToInfix(s));
    }
    public static String preToInfix(String str) {
        // code here
        Stack<String> s = new Stack<>();
        int n = str.length();
        for(int i=n-1;i>=0;i--){
            char c = str.charAt(i);
            if((c>='A' && c<='Z') || (c>='a' && c<='z') || (c>='0' && c<='9')){
                s.push(String.valueOf(c));
            }
            else{
                String t1 = s.peek();
                s.pop();
                String t2 = s.peek();
                s.pop();
                String ans = '('+t1+c+t2+')';
                s.push(ans);
            }
        }
        return s.peek();
    }
}
