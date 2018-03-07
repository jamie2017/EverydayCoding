package Math;

import java.util.Arrays;

/**
 * Created by JMYE on 11/7/16.
 */
public class MinimumMovestoEqualArrayElements {
    public int minMoves(int[] nums) {
        /*
         sum + m * (n - 1) = x * n
         x = minNum + m
         sum - minNum * n = m
        */
        if (nums == null || nums.length <= 1) return 0;
        int minNum = Integer.MAX_VALUE;
        int sumNum = 0;
        int n = 0;
        for (int num : nums) {
            n++;
            minNum = Math.min(num, minNum);
            sumNum += num;
        }
        return sumNum - n * minNum;
    }

    public int minMoves2(int[] nums) {// similar to meeting point
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1, count = 0;
        while (i < j) {
            count += nums[j] - nums[i];
            i++;
            j--;
        }
        return count;
    }
}
