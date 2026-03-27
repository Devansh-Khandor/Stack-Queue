package Stack.Conversions;

import java.util.*;

public class InfixToPostfix {
    public static void main(String args[]){
        String s = "a+b*(c^d-e)";
        System.out.println(infixpostfix(s));
    }

    public static int priority(char c){
        if(c=='^'){
            return 3;
        }
        else if(c=='*' || c=='/'){
            return 2;
        }
        else if(c=='+' || c=='-'){
            return 1;
        }
        else{
            return -1;
        }
    }

    public static String infixpostfix(String str){
        int n = str.length();
        String ans = "";
        Stack<Character> s = new Stack<>();
        int i=0;
        while(i<n){
            char c = str.charAt(i);
            if((c>='A' && c<='Z') || (c>='a' && c<='z') || (c>='0' && c<='9')){
                ans+=c;
            }
            else if(c=='('){
                s.push(c);
            }
            else if(c==')'){
                while(!s.isEmpty() && s.peek()!='('){
                    ans+=s.peek();
                    s.pop();
                }
                s.pop();
            }
            else{
                while(!s.isEmpty() && ((priority(c)<priority(s.peek())) || (priority(c)==priority(s.peek()) && c!='^'))){
                    ans+=s.peek();
                    s.pop();
                }
                s.push(c);
            }
            i++;
        }
        while(!s.isEmpty()){
            ans+=s.peek();
            s.pop();
        }
        return ans;
    }
}
