package Stack.Conversions;

import java.util.*;

public class InfixToPrefix {
    public static void main(String args[]) {
        // code here
        String s = "a*b+c/d";
        s = reverseInfix(s);
        s = infixToPostfix(s);
        s = reverse(s);
        System.out.println(s);
        
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
    
    public static String reverseInfix(String s){
        int n = s.length();
        String ans = "";
        for(int i=n-1;i>=0;i--){
            char c = s.charAt(i);
            if(c=='('){
                ans+=')';
            }
            else if(c==')'){
                ans+='(';
            }
            else{
                ans+=c;
            }
        }
        return ans;
    }
    
    public static String reverse(String s){
        int n = s.length();
        String ans = "";
        for(int i=n-1;i>=0;i--){
            char c = s.charAt(i);
            ans+=c;
        }
        return ans;
    }
    
    public static String infixToPostfix(String str){
        int n = str.length();
        Stack<Character> s = new Stack<>();
        String ans="";
        for(int i=0;i<n;i++){
            char c = str.charAt(i);
            if((c>='A'&& c<='Z') || (c>='a'&& c<='z') || (c>='0'&& c<='9')){
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
                while(!s.isEmpty() && ((priority(c)<priority(s.peek())) || (priority(c)==priority(s.peek()) && c=='^'))){
                    ans+=s.peek();
                    s.pop();
                }
                s.push(c);
            }
        }
        while(!s.isEmpty()){
            ans+=s.peek();
            s.pop();
        }
        return ans;
    }
}
