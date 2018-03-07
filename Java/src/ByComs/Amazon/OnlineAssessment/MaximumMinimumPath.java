package ByComs.Amazon.OnlineAssessment;

/**
 * Created by JMYE on 10/10/16.
 */


/*

给一个int[][]的matirx，对于一条从左上到右下的path pi，pi中的最小值是mi，求所有mi中的最大值。只能往下或右.
比如：

[8, 4, 7]
[6, 5, 9]
有3条path：
8-4-7-9 min: 4
8-4-5-9 min: 4
8-6-5-9 min: 5
return: 5


[8,3,7]
[2,3,1]
[3,6,9]

return
 */
public class MaximumMinimumPath {
    public int maxMinPath_1(int[][] matrix) {
        int[] rst = new int[matrix[0].length];
        rst[0] = matrix[0][0];
        for (int i = 1; i < matrix[0].length; i++) {
            rst[i] = Math.min(rst[i - 1],matrix[0][i]);
        }
        for (int i = 1; i < matrix.length; i++) {
            rst[0] = Math.min(matrix[i][0],rst[0]);
            for (int j = 1; j < matrix[0].length; j++) {
                rst[j] = (rst[j] < matrix[i][j] && rst[j - 1] < matrix[i][j])
                       ? Math.max(rst[j - 1], rst[j]) : matrix[i][j];
                // when condition is false, select matrx[i][i] here meet the  the rest of three possibilities requirements
            }
        }
        return rst[rst.length - 1];
    }


    private int maxMin = Integer.MIN_VALUE;

    public int maxMinPath_2(int[][] mat){
        if(mat.length == 0 || mat[0].length == 0) return maxMin;
        dfs(mat, 0, 0, Integer.MAX_VALUE);
        return maxMin;
    }

    private void dfs(int[][] mat, int i, int j, int minSofar){
        int M = mat.length, N = mat[0].length;
        //base case: out of bound (need to take care out of bounds first)
        if(i == M || j == N) return;
        //if not out of bound, update local minimum
        minSofar = Math.min(minSofar, mat[i][j]);
        //if reach last position, update maximum
        if(i == M-1 && j == N-1) {maxMin = Math.max(minSofar, maxMin);}
        //explore down and right vertexes
        dfs(mat, i + 1, j, minSofar);
        dfs(mat, i, j + 1, minSofar);
    }

    public static void main (String[] args) {
        int[][] mtx = {{8,3,7},{2,3,1},{3,6,9}};
        MaximumMinimumPath test = new MaximumMinimumPath();
        System.out.println(test.maxMinPath_1(mtx));
        System.out.println(test.maxMinPath_2(mtx));
    }
}
