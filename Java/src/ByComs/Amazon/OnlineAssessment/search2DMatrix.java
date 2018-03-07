package ByComs.Amazon.OnlineAssessment;

/**
 * Created by JMYE on 10/9/16.
 */


/*

[
[1, 3, 5, 7],
[10, 11, 16, 20],
[23, 30, 34, 50]
]

每一行都是递增的
每一行开头的数字都比上一行结尾的数字大
矩阵大小为m * n
 */
public class search2DMatrix { // binary search O(logN), N = m*n
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 ||matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length, col = matrix[0].length;
        int start = 0, end = row * col - 1;
        while (start + 1 < end) { // so that each loop can find a mid
            int mid = start + (end - start) / 2;
            int number = matrix[mid /col][mid % col];
            if (number == target) {
                return true;
            } else if (number < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (matrix[start / col][start % col] == target) {
            return true;
        } else if (matrix[end / col][end % col] == target) {
            return true;
        }

        return false;
    }

    // search 2d matrix II
    /*

    [
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
     */

    public boolean searchMatrixII(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 ||matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int col = matrix[0].length - 1;
        int row = 0;
        while (col >= 0 && row <= matrix.length - 1) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target > matrix[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
