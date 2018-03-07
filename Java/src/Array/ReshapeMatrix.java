package Array;

import java.util.Arrays;

/**
 * Created by JMYE on 6/29/17.
 */
public class ReshapeMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int or = nums.length, oc = nums[0].length;
        if (or * oc != r * c) {
            return nums;
        }
        int[][] nMtx = new int[r][c];
        for (int i = 0; i < r*c; i++) {
            nMtx[i/c][i%c] = nums[i/oc][i%oc];
        }
        return nMtx;
    }
}
