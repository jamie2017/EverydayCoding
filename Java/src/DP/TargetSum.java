package DP;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JMYE on 7/15/17.
 * 494. Target Sum
 */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> ways = new HashMap<>();
        if (nums[0] == 0) {
            ways.put(0,2);
        } else {
            ways.put(nums[0],1);
            ways.put(-nums[0],1);
        }
        Map<Integer, Integer> tmpWays;
        for (int i = 1; i < nums.length; i++) {
            tmpWays = new HashMap<>();
            for (Integer w : ways.keySet()) {
                tmpWays.put(w + nums[i],tmpWays.getOrDefault(w + nums[i],0) + ways.getOrDefault(w,0));
                tmpWays.put(w - nums[i],tmpWays.getOrDefault(w - nums[i],0) + ways.getOrDefault(w,0));
            }
            ways = tmpWays;
        }
        return ways.getOrDefault(S,0);
    }
}

