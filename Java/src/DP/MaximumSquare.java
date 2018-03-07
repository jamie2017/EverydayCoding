package DP;

/**
 * Created by JMYE on 9/4/16.
 */
public class MaximumSquare {

    /*

    Return the area of Square, we need to find the length
    dp[i][j] = the maximal length of square end at right corner (i ,j)

    1) init dp with first row and col of matrix
    2) if (matrix[i][j] == '1') {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    } else {
                        dp[i][j] = 0;
                    }
    3) return maxLen:
       maxLen = Math.max(maxLen, dp[i][j])
     */

    public int maximalSquare(char[][] matrix) {
        int maxLen = 0;
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length: 0;
        int [][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            dp[i][0] = matrix[i][0] - '0';
            maxLen = Math.max(dp[i][0],maxLen);
            for (int j = 1; j < cols; j++) {
                if (i > 0) {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    } else {
                        dp[i][j] = 0;
                    }
                } else {
                    dp[i][j] = matrix[i][j] - '0';
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }

        }
        return maxLen * maxLen;
    }


    public int maximalSquare_rolling(char[][] matrix) {
        int maxLen = 0;
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length: 0;
        int [][] dp = new int[2][cols];
        for (int i = 0; i < rows; i++) {
            dp[i % 2][0] = matrix[i][0] - '0';
            maxLen = Math.max(dp[i % 2][0],maxLen);
            for (int j = 1; j < cols; j++) {
                if (i > 0) {
                    if (matrix[i][j] == '1') {
                        dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j - 1], Math.min(dp[(i - 1) % 2][j], dp[i % 2][j - 1])) + 1;
                    } else {
                        dp[i % 2][j] = 0;
                    }
                } else {
                    dp[i % 2][j] = matrix[i][j] - '0';
                }
                maxLen = Math.max(maxLen, dp[i % 2][j]);
            }

        }
        return maxLen * maxLen;
    }




/*
    public int maxSquare(int[][] matrix) {
        // write your code here
        int ans = 0;
        int n = matrix.length;
        int m;
        if(n > 0)
            m = matrix[0].length;
        else
            return ans;
        int [][]res = new int [n][m];
        // res[i][j] = maximal length of square at the right corner spot of (i,j)
        for(int i = 0; i < n; i++){
            res[i][0] = matrix[i][0];
            ans = Math.max(res[i][0] , ans);
            for(int j = 1; j < m; j++) {
                if(i > 0) {
                    if(matrix[i][j] > 0) {
                        res[i][j] = Math.min(res[i - 1][j],Math.min(res[i][j-1], res[i-1][j-1])) + 1;
                    } else {
                        res[i][j] = 0;
                    }

                }
                else {
                    res[i][j] = matrix[i][j];
                }
                ans = Math.max(res[i][j], ans);
            }
        }
        return ans*ans;
    }

    public int maxSquare_rolling(int[][] matrix) {
        // write your code here
        int ans = 0;
        int n = matrix.length;
        int m;
        if(n > 0)
            m = matrix[0].length;
        else
            return ans;
        int [][]res = new int [2][m];
        // odd num % 2 = 1
        // even num % 2 = 0
        for(int i = 0; i < n; i++){
            res[i%2][0] = matrix[i][0];
            ans = Math.max(res[i%2][0] , ans);
            for(int j = 1; j < m; j++) {
                if(i > 0) {
                    if(matrix[i][j] > 0) {
                        res[i%2][j] = Math.min(res[(i - 1)%2][j],Math.min(res[i%2][j-1], res[(i-1)%2][j-1])) + 1;
                    } else {
                        res[i%2][j] = 0;
                    }

                }
                else {
                    res[i%2][j] = matrix[i%2][j];
                }
                ans = Math.max(res[i%2][j], ans);
            }
        }
        return ans*ans;
    }
*/

    public int maximalSquare_1d(char[][] matrix) {
        int row = matrix.length, col = row > 0 ? matrix[0].length: 0;
        int maxSqLen = 0, prev = 0;
        int[] dp = new int[col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1],prev),dp[j]) + 1;
                    maxSqLen = Math.max(maxSqLen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;

            }
        }
        return maxSqLen * maxSqLen;

    }
}
