package Greedy;

import java.util.Arrays;

/**
 * Created by JMYE on 7/24/17.
 * 646. Maximum Length of Pair Chain
 */
public class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b)->a[1] - b[1]);
        int cur = Integer.MIN_VALUE;
        int maxLen = 0;
        for (int[] p: pairs) {
            if (cur < p[0]) {
                cur = p[1];
                maxLen ++;
            }
        }
        return maxLen;
    }
}
