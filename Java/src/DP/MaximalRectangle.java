package DP;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by JMYE on 9/25/16.
 */
public class MaximalRectangle {

    // solution 1
    public int maximalRectangle(char[][] matrix) { // O(n * m)
        if (matrix.length < 1) return 0;
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        if (m == 0) return 0;
        int[][] height = new int[n][m];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (i == 0)
                    height[i][j] = ((matrix[i][j] == '1') ? 1 : 0); // initial first row
                else
                    height[i][j] += ((matrix[i][j] == '1') ? height[i-1][j] + 1 : 0);
            }
        }

        // Then take each row applying the approach in finding "Largest Rectangle in Histogram"
        // loop through each row to find the maximal
        int answer = 0;
        for (int i = 0; i < n; ++i) {
            Stack<Integer> s = new Stack<Integer>();
            for (int j = 0; j <= m; j++) {
                int h = (j == m ? 0 : height[i][j]);
                if (s.isEmpty() || h >= height[i][s.peek()]) {
                    s.push(j);
                } else {
                    int tp = s.pop();
                    answer = Math.max(answer, height[i][tp] * (s.isEmpty() ? j : j - 1 - s.peek()));
                    j--;
                }
            }
        }
        return answer;
    }


    // solution 2 :  for each row , two pointers
    /*

    height counts the number of successive '1's above (plus the current one).
    The value of left & right means the boundaries of
    the rectangle which contains the current point with a height of value height. !!!!!!!
     */



    public int maximalRectangle2(char[][] matrix) { // MARK! SMART!!!
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        int res = 0;
        Arrays.fill(right, n);
        Arrays.fill(height, 0);
        for (int i = 0; i < m; i++) {
            int cur_left = 0, cur_right = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], cur_left);
                } else {
                    cur_left = j + 1;
                    left[j] = 0;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], cur_right);
                } else {
                    cur_right = j;
                    right[j] = n;
                }
            }
            for (int j = 0; j < n; j++) {
                res = Math.max(res, (right[j] - left[j])*height[j]);
            }
        }
        return res;

    }


    public static void main (String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},
                           {'1','0','1','1','1'},
                           {'1','1','1','1','1'},
                           {'1','0','0','1','0'}};
        MaximalRectangle test = new MaximalRectangle();
        System.out.println(test.maximalRectangle2(matrix));
    }
}
