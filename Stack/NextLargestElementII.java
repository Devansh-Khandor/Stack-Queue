package Stack;

import java.util.*;
/* Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number. */

public class NextLargestElementII {

    public static void main(String args[]){
        int nums[] = {1,2,3,4,3};
        print(nextGreaterElementsLoops(nums));
        print(nextGreaterElements(nums));
    }

    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static int[] nextGreaterElementsLoops(int[] arr) {
        int n = arr.length;
        int nge[] = new int[n];
        Arrays.fill(nge, -1);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=i+n-1;j++){
                int idx = j%n;
                if(arr[idx]>arr[i]){
                    nge[i] = arr[idx];
                    break;
                }
            }
        }
        return nge;
    }

    public static int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int res[] = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            while(!s.isEmpty() && s.peek()<=arr[i%n]){
                s.pop();
            }
            if(i<n){
                res[i] = s.isEmpty()?-1:s.peek();
            }
            s.push(arr[i%n]);
        }
        return res;
    }

}
