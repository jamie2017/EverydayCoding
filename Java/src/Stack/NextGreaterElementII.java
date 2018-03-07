package Stack;

import java.util.Stack;

/**
 * Created by JMYE on 3/17/17.
 */
public class NextGreaterElementII {
    public int[] nextGreaterElementII(int[] nums) {
        int[] rst = new int[nums.length];
        Stack<Integer> stk = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            while (!stk.empty() && nums[stk.peek()] <= nums[i % nums.length]) {
                stk.pop();
            }
            rst[i % nums.length] = stk.empty() ? -1 : nums[stk.peek()];
            stk.push(i % nums.length);
        }
        return rst;
    }
}
