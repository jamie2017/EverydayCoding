package ByComs.Palantir;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JMYE on 11/2/16.
 */
public class MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        int result = 0, sum = 0;
        hm.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (hm.containsKey(sum - k)) result = Math.max(i - hm.get(sum - k), result);
            if (!hm.containsKey(sum)) hm.put(sum, i);
        }
        return result;
    }
}
