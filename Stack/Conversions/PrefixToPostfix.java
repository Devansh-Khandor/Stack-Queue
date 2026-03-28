package Stack.Conversions;

import java.util.*;

public class PrefixToPostfix {
    public static void main(String args[]){
        String s = "*-A/BC-/AKL";
        System.out.println(preToPost(s));
    }

    public static String preToPost(String str) {
        // code here
        int n = str.length();
        Stack<String> s = new Stack<>();
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
                String ans = t1+t2+c;
                s.push(ans);
            }
        }
        return s.peek();
    }
}
