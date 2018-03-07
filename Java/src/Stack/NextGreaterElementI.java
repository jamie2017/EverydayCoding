package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by JMYE on 3/17/17.
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Stack<Integer> stk = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        int[] rst = new int[findNums.length];
        for (int num: nums) {
            while(!stk.empty() && num > stk.peek()) {
                map.put(stk.pop(),num);
            }
            stk.add(num);
        }
        while (!stk.empty()) {
            map.put(stk.pop(), -1);
        }
        for (int i = 0; i < findNums.length; i++) {
            rst[i] = map.get(findNums[i]);
        }
        return rst;
    }

}
