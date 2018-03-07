package Stack;

import java.util.Stack;

/**
 * Created by JMYE on 3/16/17.
 */
public class MaximumContinueDays {
    public int[] maxDays(int[] arr) {
        int size = arr.length;
        Stack<Integer> stk = new Stack<>();
        int[] rst = new int[size];
        int idx = 0;
        while (idx < size) {
            while (!stk.empty() && arr[idx] >= arr[stk.peek()]) {
                stk.pop();
            }
            if (!stk.empty()) {
                rst[idx] = idx - stk.peek();
            } else {
                rst[idx] = idx + 1;
            }
            stk.add(idx);
            idx += 1;
        }
        return rst;
    }

    public static void main(String[] args) {
        MaximumContinueDays test = new MaximumContinueDays();
        int[] arr = {3,5,6,4,5,6,1,1,1,9,8,7};
        int [] rst = test.maxDays(arr);
        for (int d: rst) {
            System.out.println(d);
        }
    }
}
