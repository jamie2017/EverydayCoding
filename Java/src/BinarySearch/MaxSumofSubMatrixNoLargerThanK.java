package BinarySearch;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by JMYE on 9/28/16.
 */
public class MaxSumofSubMatrixNoLargerThanK {


    // assume #of columns is smaller
    public int maxSumSubmatrix(int[][] matrix, int k) { // O(col * col * row * log row）
        int rows = matrix.length, cols = matrix[0].length, ans = Integer.MIN_VALUE;
        for (int L = 0; L < cols; ++L) {
            long[] sumInRow = new long[rows];
            for (int R = L; R < cols; ++R) {
                TreeSet<Integer> set = new TreeSet<>();
                int sum = 0;
                for (int p = 0; p < rows; ++p) {
                    sumInRow[p] += matrix[p][R];
                    sum += sumInRow[p];
                    if (sum <= k) ans = Math.max(ans, sum);
                    //use  TreeMap to binary search previous sum to get possible result
                    Integer subSum = set.ceiling(sum - k);
                    // we want ans <= k
                    // sum - subSum <= k, thus subSum >= sum - k , which is set.ceiling(sum - k) = subSum
                    if (subSum != null) ans = Math.max(ans, sum - subSum);
                    set.add(sum);
                }
            }
        }
        return ans;
    }
}
