package Stack;

import java.util.*;

public class NextSmallestElement {

    public static void main(String args[]){
        int arr[] = {4, 8, 5, 2, 25};
        System.out.println(nextSmallerEle(arr));
    }
    
    public static ArrayList<Integer> nextSmallerEle(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && s.peek()>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                list.add(-1);
                s.push(arr[i]);
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
