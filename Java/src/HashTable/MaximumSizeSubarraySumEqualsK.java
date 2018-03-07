package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JMYE on 9/13/16.
 */
public class MaximumSizeSubarraySumEqualsK {// O(n)
    /*

    The HashMap stores the sum of all elements before index i as key,
    and i as value. For each i,
    check not only the current sum but also (currentSum - previousSum)
    to see if there is any that equals k,
    and update max length.
     */
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) max = i + 1;
            else if (map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums = {-2,-1,2,1};
        MaximumSizeSubarraySumEqualsK test = new MaximumSizeSubarraySumEqualsK();
        System.out.println(test.maxSubArrayLen(nums,1));
    }
}
