package DP;

/**
 * Created by JMYE on 3/16/17.
 */
public class FindMinimumNumberOfCoinsThatMakeAGivenValue {

    public int minCoins(int[] coins, int m, int V) { // exponetional
        if (V == 0) return 0;
        int rst = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if (coins[i] <= V) {
                int subRst = minCoins(coins, m, V - coins[i]);
                if (subRst != Integer.MAX_VALUE && subRst + 1 < rst) {
                    rst = subRst + 1;
                }
            }
        }
        return rst;
    }

    public int minCoinsOpt(int[] coins, int m, int V) {// O(mV)
        int[] dp = new int[V + 1];
        dp[0] = 0;
        for (int i = 1; i <= V; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= V; i++) {
            for (int j = 0; j < m; j++) {
                if(coins[j] <= i) {
                    int subRst = dp[i - coins[j]];
                    if (subRst != Integer.MAX_VALUE && subRst + 1 < dp[i]) {
                        dp[i] = subRst + 1;
                    }
                }
            }
        }
        return dp[V];
    }

}
