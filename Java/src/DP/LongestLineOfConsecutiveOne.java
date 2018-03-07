package DP;

/**
 * Created by JMYE on 5/10/17.
 * 562. Longest Line of Consecutive One in Matrix
 */
public class LongestLineOfConsecutiveOne {
    public int longestLine(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }
        int rows = M.length, cols = M[0].length;
        int longestLen = 0;
        int[][][] dp = new int[rows][cols][4];
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j++) {
                if(M[i][j] == 0) continue;
                for (int k = 0; k < 4; k++) {
                    dp[i][j][k] = 1;
                }
                if (j > 0) {
                    dp[i][j][0] += dp[i][j - 1][0]; // horizontal line
                }
                if (j > 0 && i > 0) {
                    dp[i][j][1] += dp[i - 1][j - 1][1]; // anti-diagonal line
                }
                if (i > 0) {
                    dp[i][j][2] += dp[i - 1][j][2]; // vertical line
                }
                if (j < cols - 1 && i > 0) {
                    dp[i][j][3] += dp[i - 1][j + 1][3];// diagonal line
                }
                longestLen = Math.max(longestLen,dp[i][j][0]);
                longestLen = Math.max(longestLen,dp[i][j][1]);
                longestLen = Math.max(longestLen,dp[i][j][2]);
                longestLen = Math.max(longestLen,dp[i][j][3]);
            }
        }
        return longestLen;
    }
}
