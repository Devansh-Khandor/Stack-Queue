package Stack;

import java.util.*;

/*Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7. */

public class SumOfSubarrayMinimums {
    public static void main(String args[]){
        int arr[] = {3,1,2,4};
        int n = arr.length;
        int nse[] = new int[n];
        int pse[] = new int[n];
        int mod = (int)Math.pow(10, 9)+7;
        nse = nse(arr);
        pse = pse(arr);
        long total = 0;
        for(int i=0;i<arr.length;i++){
            int left = i-pse[i];
            int right = nse[i]-i;
            
            long contribution = (left*right)%mod;
            contribution = (contribution*arr[i])%mod;
            total = (total+contribution)%mod;

        }
        System.out.println((int)total);
    }

    public static int[] nse(int arr[]){
        int n = arr.length;
        int res[] = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            res[i] = s.isEmpty()?n:s.peek();
            s.push(i);
        }
        return res;
    }
    public static int[] pse(int arr[]){
        int n = arr.length;
        int res[] = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && arr[s.peek()]>arr[i]){
                s.pop();
            }
            res[i] = s.isEmpty()?-1:s.peek();
            s.push(i);
        }
        return res;
    }
}
