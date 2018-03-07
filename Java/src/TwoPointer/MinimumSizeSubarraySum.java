package TwoPointer;

/**
 * Created by JMYE on 9/3/16.
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int[] nums, int s) {
        int L = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int R = 0; R < nums.length; R++) {
            sum += nums[R];
            while (sum >= s) {
                minLen = Math.min(minLen, R - L + 1);
                sum -=nums[L];
                L += 1;
            }
        }
        return minLen < Integer.MAX_VALUE? minLen:0;
    }
}
