package DP;

/**
 * Created by JMYE on 9/17/16.
 */
public class GuessNumberHigherorLowerII {// MARK

    int[][] dp;
    public int getMoneyAmount(int n) {
        dp = new int[n + 1][n + 1];
        return helper(1,n);
    }

    private int helper(int start, int end) {
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        if (start >= end) {
            return 0;
        }

//        if (start >= end - 2) { // Optimal 3: need to check bound if use optimal 2
//            return dp[start][end] = end - 1;
//        }

        int ans = Integer.MAX_VALUE;
         for (int x = start; x < end; x++) { // O(n)
              int left = helper(start, x - 1);
              int right = helper(x + 1, end);
              ans = Math.min(ans, x + Math.max(left,right));
              if(left >= right) break;  // Optimal1
         }

//        // Optimal 2, use binary search instead of for loop
//        int mid = (start + end) / 2 - 1;
//        while (mid < end) { // O(lgn)
//            int left = helper(start, mid - 1);
//            int right = helper(mid + 1, end);
//            ans = Math.min(ans, mid + Math.max(left,right));
//            if(left >= right) break;  // Optimal1
//            mid++;
//        }
        dp[start][end] = ans;
        return ans;
    }


    // bottom up
    public int getMoneyAmount_bottomUp(int n) {
        int[][] dp = new int[n + 1][n + 1];
        // dp[i][j] == the min cost from guess i to j
        for (int j = 2; j <= n; j++){
            for (int i = j - 1; i > 0; i--) {
                int globalMin = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int localMax = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
                    globalMin = Math.min(globalMin, localMax);
                }
                dp[i][j] = i + 1 == j ? i : globalMin;
                // when i + 1 == j, like dp[1][2] ,dp[23][24],
                // min cost would be the smaller one, which is i
            }
        }
        return dp[1][n];
    }


}
