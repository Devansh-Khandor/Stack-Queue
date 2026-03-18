package Stack;
import java.util.*;
public class StackUsingQueue {
    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();
    @SuppressWarnings("resource")
    public static void main(String args[]){
        int c = -1;
        Scanner ob = new Scanner(System.in);
        do{
            System.out.println("Choose one of the options:\n1.Push\n2.Pop\n3.Peek\n4.Print");
            int ch = ob.nextInt();
            if(ch==1){
                System.out.println("Enter the value to be pushed");
                int x = ob.nextInt();
                push(x);
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
    public static void push(int x){
        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }
        q1.add(x);
        while(!q2.isEmpty()){
            q1.add(q2.remove());
        }
    }

    public static void print(){
        while(!q1.isEmpty()){
            System.out.print(q1.peek()+" ");
            q2.add(q1.remove());
        }
        while(!q2.isEmpty()){
            q1.add(q2.remove());
        }
        System.out.println();
    }

    public static int pop(){
        if(q1.isEmpty()){
            return -1;
        }
        int top = q1.peek();
        q1.remove();
        return top;

    }

    public static int top(){
        if(q1.isEmpty()){
            return -1;
        }
        return q1.peek();
    }

}
