package DP;

/**
 * Created by JMYE on 9/2/16.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSoFar=nums[0], maxEndingHere=nums[0];
        for (int i = 1;i < nums.length; ++i){
            maxEndingHere = Math.max(maxEndingHere + nums[i],nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

}
