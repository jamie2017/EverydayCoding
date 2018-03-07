package DP;

/**
 * Created by JMYE on 8/25/16.
 */

// 70. Climbing Stairs
// In how many distinct ways can you climb to the top?
public class ClimbingStairs {
    public int climbStairs(int n) {
        // dp[i] = dp[i-1] + dp[i-2]
        // if (n == 0) return 0;
        // if (n <= 1) return 1;
        // int[] dp = new int[n+1];
        // dp[0] = 1;
        // dp[1] = 1;
        // for (int i = 2; i <= n; i++) {
        //     dp[i] = dp[i-1]+dp[i-2];
        // }
        // return dp[n];

        int currStep = 0;
        int preOneStep = 1, preTwoStep = 1;
        if (n == 1) {
            return 1;
        }
        for(int i = 2; i <= n; i++) {
            currStep = preOneStep + preTwoStep;
            preTwoStep = preOneStep;
            preOneStep = currStep;

        }
        return currStep;
    }
}
