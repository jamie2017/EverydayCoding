package DP;

import java.util.Arrays;

/**
 * Created by JMYE on 9/17/16.
 */
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {// TLE
        if (target == 0) {
            return 1;
        }
        int rst = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                rst += combinationSum4(nums, target - nums[i]);
            }
        }

        return rst;

    }

    private int[] dp;
    public int combinationSum4_DP(int[] nums, int target) { // 1ms because dp store the intermediate results
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums,target);
    }

    private int helper(int[] nums,int target) {
        if (dp[target] != -1) {
            return dp[target];
        }

        int rst = 0;
        for (int i = 0; i < nums.length;i++) {
            if (target >= nums[i]) {
                rst += helper(nums, target - nums[i]);
            }
        }
        dp[target] = rst;
        return rst;
    }

    public int combinationSum4_bottomUp(int[] nums, int target) {
        int[] comb = new int[target + 1];
        comb[0] = 1;
        for (int i = 1; i < comb.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    comb[i] += comb[i - nums[j]];
                }
            }
        }
        return comb[target];
    }
}
