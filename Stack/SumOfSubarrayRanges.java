package Stack;

import java.util.*;

public class SumOfSubarrayRanges {

    public static void main(String args[]){
        int arr[]= {1,2,3};
        long res = sumSubarrayMaxs(arr)-sumSubarrayMins(arr);
        System.out.println(res);
    }

    public static long sumSubarrayMaxs(int arr[]){
        int n = arr.length;
        int pge[] = new int[n];
        pge = pge(arr);
        int nge[] = new int[n];
        nge = nge(arr);
        long total = 0;
        for(int i=0;i<n;i++){
            long left = i - pge[i];
            long right = nge[i] - i;
            total += (right*left*arr[i]);
        }
        return total;
    }

    public static int[] nge(int arr[]){
        Stack<Integer> s = new Stack<>();
        int[] res = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                res[i] = arr.length;
            }
            else{
                res[i] = s.peek();
            }
            s.push(i);
        }
        return res;
    }

    public static int[] pge(int arr[]){
        Stack<Integer> s = new Stack<>();
        int[] res = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()]<arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                res[i] = -1;
            }
            else{
                res[i] = s.peek();
            }
            s.push(i);
        }
        return res;
    }

    public static long sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int pse[] = new int[n];
        pse = pse(arr);
        int nse[] = new int[n];
        nse = nse(arr);
        long total = 0;
        for(int i=0;i<n;i++){
            long left = i - pse[i];
            long right = nse[i] - i;
            total += (right*left*arr[i]);
        }
        return total;
    }

    public static int[] nse(int arr[]){
        Stack<Integer> s = new Stack<>();
        int[] res = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                res[i] = arr.length;
            }
            else{
                res[i] = s.peek();
            }
            s.push(i);
        }
        return res;
    }

    public static int[] pse(int arr[]){
        Stack<Integer> s = new Stack<>();
        int[] res = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()]>arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                res[i] = -1;
            }
            else{
                res[i] = s.peek();
            }
            s.push(i);
        }
        return res;
    }
}
