package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 9/3/16.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int count = 0;
        while (count * 2 < rows && count * 2 < cols) {
            for (int i = count; i < cols - count; i++) {
                res.add(matrix[count][i]);
            }

            for (int i = count + 1;i < rows - count; i++) {
                res.add(matrix[i][cols - count - 1]);
            }

            if (rows - 2 * count == 1 || cols - 2 * count == 1) break;

            for (int i = cols - count - 2; i >= count; i--) {
                res.add(matrix[rows - count - 1][i]);
            }
            for (int i = rows - count - 2; i >= count + 1; i--) {
                res.add(matrix[i][count]);
            }

            count ++;
        }
        return res;
    }
}
