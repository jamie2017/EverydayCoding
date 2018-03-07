package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JMYE on 3/15/17.
 */
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int preSum = 0;
        int prev = -1;
        sumMap.put(preSum,prev);
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if(k != 0) {
                preSum %= k;
            }
            if (!sumMap.containsKey(preSum)) {
                sumMap.put(preSum, i);
            } else {
                prev = sumMap.get(preSum);
                if (i - prev > 1) {
                    return true;
                }
            }
        }
        return false;
    }

//    560. Subarray Sum Equals K
    public int subarraySum(int[] nums, int k) {
        int preSum = 0, ans = 0;
        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0,1); // case like [0,0]0
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (preSumMap.containsKey(preSum - k)) {
                ans += preSumMap.get(preSum - k);
            }
            preSumMap.put(preSum, preSumMap.getOrDefault(preSum,0) + 1);
        }
        return ans;
    }
}
