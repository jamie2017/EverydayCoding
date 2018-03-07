package Array;

/**
 * Created by JMYE on 9/13/16.
 */
public class RotateImage {

    /*

    The idea was firstly transpose the matrix and then flip it symmetrically. For instance,

1  2  3
4  5  6
7  8  9
after transpose, it will be swap(matrix[i][j], matrix[j][i])

1  4  7
2  5  8
3  6  9
Then flip the matrix horizontally. (swap(matrix[i][j], matrix[i][matrix.length-1-j])

7  4  1
8  5  2
9  6  3
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int row = matrix.length, col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col / 2;j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][row - 1 -j];
                matrix[i][row - 1 -j] = tmp;
            }
        }
    }
}
