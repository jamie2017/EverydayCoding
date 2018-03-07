package Array;

/**
 * Created by JMYE on 9/12/16.
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if (n < 0) {
            return null;
        }

        int[][] result = new int[n][n];

        int xStart = 0;
        int yStart = 0;
        int num = 1;
        while (n > 0) {
            if (n == 1) {
                result[xStart][yStart] = num++;
                break;
            }

            for (int i = 0; i < n - 1; i ++) {
                result[xStart][yStart + i] = num++;
            }
            for (int i = 0; i < n - 1; i++) {
                result[xStart + i][yStart + n - 1] = num++;
            }
            for (int i = 0; i < n - 1; i++) {
                result[xStart + n - 1][yStart + n - 1 - i] = num++;
            }
            for (int i = 0; i < n - 1; i++) {
                result[xStart + n - 1 - i][yStart] = num++;
            }
            xStart++;
            yStart++;
            n = n - 2;

        }
        return result;
    }
}
