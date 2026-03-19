package Stack;

import java.util.*;

public class NextLargestElement {

    public static void main(String args[]){
        int arr[] = {6, 8, 0, 1, 3};
        System.out.println(nextLargerElement(arr));
    }
    
    
    public static ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        Stack<Integer> s = new Stack<Integer>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=arr.length-1;i>=0;i--){
            if(s.isEmpty()){
                list.add(-1);
                s.push(arr[i]);
                continue;
            }
            while(!s.isEmpty() && s.peek()<=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                list.add(-1);
                s.push(arr[i]);
                continue;
            }
            else{
                list.add(s.peek());
                s.push(arr[i]);
            }
        }
        Collections.reverse(list);
        return list;
    }
}
