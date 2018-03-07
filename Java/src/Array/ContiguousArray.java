package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JMYE on 2/23/17.
 */
//525. Contiguous Array
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, 0);
        int sum = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                sum --;
            } else {
                sum ++;
            }
            if (sumToIndex.containsKey(sum)) {
                max = Math.max(max, i - sumToIndex.get(sum) + 1);
            }
            else {
                sumToIndex.put(sum, i + 1 );
            }
        }

        return max;
    }

    public static void main(String[] args) {
        ContiguousArray test = new ContiguousArray();
        int[] nums = {0,1};
        System.out.println(test.findMaxLength(nums));
    }
}
