package ByComs.Amazon.OnlineAssessment;

/**
 * Created by JMYE on 10/10/16.
 */

/*

Given an array, return the number of possible arithmetic sequence.
给一个数组，返回可能的等差数列个数。
 */
public class ArithmeticSlice { // MARK
    public static int getLAS(int[] A){
        // Time: O(n)
        // Space: O(1)
        if (A.length < 3) return 0;

        int res = 0;
        int diff = Integer.MIN_VALUE;
        int count = 0;
        int start = 0;
        for (int i = 1; i < A.length; i++){
            int currDiff = A[i] - A[i - 1];
            if (diff == currDiff){
                // 比较难想到的一步！！！
                count += i - start - 1 > 0 ? i - start - 1 : 0;
            } else {
                start = i - 1;
                diff = currDiff;
                res += count;
                count = 0;
            }
        }
        res += count;
        return res;
    }
}
