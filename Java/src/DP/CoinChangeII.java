package DP;

/**
 * Created by JMYE on 3/17/17.
 */
public class CoinChangeII {
    // compute the number of combinations that make up that amount.
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int c: coins) {
            for(int i = c; i <= amount; i++) {
                dp[i] += dp[i - c];
            }
        }
        return dp[amount];
    }
}
