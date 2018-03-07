package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by JMYE on 7/30/17.
 */
public class DiagonalTraversal {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int row = matrix.length, col = matrix[0].length;
        int idx = 0;
        int[] ans = new int[row * col];
        for (int i = 0; i < row + col; i++) {
            int lowerBound = Math.max(0, i - col + 1);
            int upperBound = Math.min(row - 1, i);
            if (i % 2 == 0) { // up
                for (int j = upperBound; j >= lowerBound; j--) {
                    ans[idx] = matrix[j][i - j];
                    idx ++;
                }
            } else { // down
                for (int j = lowerBound; j <= upperBound; j++) {
                    ans[idx] = matrix[j][i - j];
                    idx ++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        DiagonalTraversal test = new DiagonalTraversal();
        int[][] matrix = {{1,2,3},
                          {4,5,6},
                          {7,8,9}};
        System.out.println(Arrays.toString(test.findDiagonalOrder(matrix)));
    }
}
