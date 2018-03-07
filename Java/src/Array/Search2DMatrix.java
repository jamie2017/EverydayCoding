package Array;

/**
 * Created by JMYE on 9/12/16.
 */
public class Search2DMatrix { // convert to 1D sorted array

    /*

    [
        [1,   3,  5,  7],
        [10, 11, 16, 20],
        [23, 30, 34, 50]
    ]

     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 ||matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length, col = matrix[0].length;
        int start = 0, end = row * col - 1;
        while (start + 1 < end) {
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
}
