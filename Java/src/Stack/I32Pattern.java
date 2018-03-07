package Stack;

import java.util.Stack;

/**
 * Created by JMYE on 11/18/16.
 */
class Pair{
    int min, max;
    public Pair(int min, int max) {
        this.min = min;
        this.max = max;
    }
}
public class I32Pattern {

    public static boolean find132pattern(int[] nums) {
        Stack<Pair> stack = new Stack<>();
        for (int n : nums) {
            if (stack.isEmpty() || n < stack.peek().min) {
                stack.push(new Pair(n,n));
            } else if (n > stack.peek().min){
                Pair last = stack.pop();
                if (n < last.max) {
                    return true;
                } else {
                    last.max = n;
                    while (!stack.isEmpty() && n >= stack.peek().max) {
                        stack.pop();
                    }
                    if (!stack.isEmpty() && stack.peek().min < n) return true;
                    stack.push(last);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] nums = {1,0,1,-4,-3};
        int[] nums = {-2,1,-2};
        System.out.println(find132pattern(nums));
    }
}
