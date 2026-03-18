package Queue;

public class QueueUsingLL {

    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static class Queue{
        public Node head;
        public boolean isEmpty(Node head){
            return head == null;
        }

        public void add(int x){
            Node newNode = new Node(x);
            if(head == null){
                head = newNode;
                return;
            }
            Node curr = head;
            while(curr.next!=null){
                curr = curr.next;
            }
            curr.next = newNode;
        }

        public int remove(){
            if(isEmpty(head)){
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        public int top(){
            if(isEmpty(head)){
                return -1;
            }
            return head.data;
        }

        public boolean isEmpty(){
            return head == null;
        }
    }

    

    public static void main(String args[]){
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.remove();
        System.out.println(q.top());
        while(!q.isEmpty()){
            System.out.print(q.top()+" ");
            q.remove();
        }
    }
}
