package DP;

/**
 * Created by JMYE on 12/20/16.
 */
public class OnesandZeroes {
//    Time Complexity: O(kl + kmn), where k is the length of input string array and l is the average length of a string within the array.
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int[][] strList = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') {
                    strList[i][0] ++;
                } else {
                    strList[i][1] ++;
                }
            }
        }
        for (int[] z_o: strList) {
            for (int i = m; i >= 0; i--) {
                for (int j = n; j>= 0; j--) {
                    if (i >= z_o[0]  &&  j >= z_o[1]) {
                        dp[i][j] = Math.max(dp[i][j], 1 + dp[i - z_o[0]][j - z_o[1]]);
                    }
                }
            }
        }
        return dp[m][n];
    }


}
