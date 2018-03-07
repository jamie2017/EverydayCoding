package DP;

/**
 * Created by JMYE on 9/29/16.
 */
public class BurstBalloons{
    public int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length + 2];
        int n = 1;
        for (int x : nums) {
            if (x > 0) {
                newNums[n++] = x;
            }
        }
        newNums[0] = newNums[n++] = 1;

        int[][] memo = new int[n][n];
        return burst(memo, newNums, 0, n - 1);
    }
    // memo[left][right]: memo store the max coins from left to right
    private int burst(int[][] memo, int[] nums, int left, int right) {
        if (left + 1 == right) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int ans = 0;
        for (int i = left + 1; i < right; ++i) {
            ans = Math.max(ans, nums[left] * nums[i] * nums[right]
            + burst(memo, nums, left, i) + burst(memo, nums, i, right));
        }
        memo[left][right] = ans;
        return ans;
    }

    // solution 2
    public int maxCoins_dp(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;


        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    dp[left][right] = Math.max(dp[left][right],
                            nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
            }

        return dp[0][n - 1];
    }
}

