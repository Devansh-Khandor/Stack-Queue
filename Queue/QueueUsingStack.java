package Queue;

import java.util.*;

public class QueueUsingStack {
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();
    @SuppressWarnings("resource")
    public static void main(String args[]){
        int c = -1;
        Scanner ob = new Scanner(System.in);
        do{
            System.out.println("Choose one of the options:\n1.Add\n2.Remove\n3.Peek\n4.Print");
            int ch = ob.nextInt();
            if(ch==1){
                System.out.println("Enter the value to be added");
                int x = ob.nextInt();
                add(x);
            }
            else if(ch==2){
                int top = pop();
                if(top==-1){
                    System.out.println("Queue Empty");
                }
                else{
                    System.out.println("Element removed: "+ top);
                }
                
            }
            else if(ch==3){
                int top = top();
                if(top==-1){
                    System.out.println("Queue Empty");
                }
                else{
                    System.out.println("Element at top: "+ top);
                }
            }
            else if(ch==4){
                print();
            }
            else{
                System.out.println("Wrong choice!");
            }
            System.out.println("1.Repeat\n2.Exit");
            c = ob.nextInt();
        }while(c==1);
        System.out.println("END");
    }

    public static void add(int x){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(x);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    public static int pop(){
        if(s1.isEmpty()){
            return -1;
        }
        int top = s1.peek();
        s1.pop();
        return top;
    }

    public static int top(){
        if(s1.isEmpty()){
            return -1;
        }
        return s1.peek();
    }

    public static void print(){
        while(!s1.isEmpty()){
            System.out.print(s1.peek()+" ");
            s2.push(s1.pop());
        }
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        System.out.println();
    }
}
