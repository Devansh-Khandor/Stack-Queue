package Stack;

import java.util.*;

public class ValidParenthesis {
    public static void main(String args[]){
        String s = "()[]{}";
        System.out.println(isValid(s));
        s = "(]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if(s.length()==0){
            return true;
        }
        Stack<Character> s1 = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                s1.push(c);
            }
            else if(c==')'){
                if(s1.isEmpty()){
                    return false;
                }
                else if(s1.peek()=='('){
                    s1.pop();
                }
                else{
                    return false;
                }
            }
            else if(c=='{'){
                s1.push(c);
            }
            else if(c=='}'){
                if(s1.isEmpty()){
                    return false;
                }
                else if(s1.peek()=='{'){
                    s1.pop();
                }
                else{
                    return false;
                }
            }
            else if(c=='['){
                s1.push(c);
            }
            else if(c==']'){
                if(s1.isEmpty()){
                    return false;
                }
                else if(s1.peek()=='['){
                    s1.pop();
                }
                else{
                    return false;
                }
            }
            else{
                continue;
            }
            
        }
        if(s1.isEmpty()){
            return true;
        }
        return false;
    }
}
