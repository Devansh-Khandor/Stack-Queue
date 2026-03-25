package Stack;

import java.util.*;

public class StockSpanner {

    public static void main(String args[]){
        StockSpanner obj = new StockSpanner();

        int[] inputs = {7, 2, 1, 3, 3, 1, 8};

        for (int price : inputs) {
            int result = obj.next(price);
            System.out.print(result + " ");
        }
    }

    Stack<int[]> s = new Stack<>();
    int idx = -1;
    public StockSpanner() {
        s = new Stack<>();
        idx = -1;
    }
    public int next(int price) {
        idx = idx+1;
        while(!s.isEmpty() && s.peek()[0]<=price){
            s.pop();
        }
        int ans = idx-(s.isEmpty()?-1:s.peek()[1]);
        s.push(new int[]{price, idx});
        return ans;
    }
}
