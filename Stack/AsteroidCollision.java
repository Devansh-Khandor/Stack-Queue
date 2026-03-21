package Stack;

import java.util.*;

public class AsteroidCollision {
    public static void main(String args[]){
        int asteroids[] = {3,5,-6,2,-1,4};
        print(asteroidCollision(asteroids));
    }

    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static int[] asteroidCollision(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(s.isEmpty()){
                s.push(arr[i]);
                continue;
            }
            if(arr[i]>=0){
                s.push(arr[i]);
            }
            else{
                while(!s.isEmpty() && s.peek()>=0 && s.peek()<Math.abs(arr[i])){
                    s.pop();
                }
                if(!s.isEmpty() && s.peek()>=0 && s.peek()==Math.abs(arr[i])){
                    s.pop();
                }
                else if(!s.isEmpty() && s.peek()<0 || s.isEmpty()){
                    s.push(arr[i]);
                }
                else if(!s.isEmpty() && s.peek()>Math.abs(arr[i])){
                    continue;
                }
                else{
                    continue;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!s.isEmpty()){
            list.add(s.peek());
            s.pop();
        }
        Collections.reverse(list);
        int size = list.size();
        int res[] = new int[size];
        for(int i=0;i<size;i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
