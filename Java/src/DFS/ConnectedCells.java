package DFS;

/**
 * Created by JMYE on 12/22/16.
 */
// 8 directions
public class ConnectedCells {
    public static int getRegionSize(int[][] matrix, int row, int col) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[row].length) {
            return 0;
        }
        if (matrix[row][col] == 0) {
            return 0;
        }

        matrix[row][col] = 0;
        int size = 1;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (r != row || c != col) {
                    size += getRegionSize(matrix,r,c);
                }
            }
        }
        return size;
    }

    public static int getBiggestRegion(int[][] matrix) {
        int maxRegion = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 1) {
                    int size = getRegionSize(matrix,row, col);
                    maxRegion = Math.max(maxRegion, size);
                }
            }
        }
        return maxRegion;
    }
}




/*


0 0 0 1 1 0 0
0 1 0 0 1 1 0
1 1 0 1 0 0 1
0 0 0 0 0 1 0
1 1 0 0 0 0 0
0 0 0 1 0 0 0

>> 7
 */
