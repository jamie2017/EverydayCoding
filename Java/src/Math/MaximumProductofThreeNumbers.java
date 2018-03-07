package Math;

/**
 * Created by JMYE on 6/25/17.
 * 628. Maximum Product of Three Numbers
 * EASY
 */

public class MaximumProductofThreeNumbers {
    public int maximumProduct(int[] nums) {
        // Arrays.sort(nums);
        // int ans = Integer.MIN_VALUE;
        // int size = nums.length;
        // ans = nums[size - 1] * nums[size - 2] * nums[size - 3];
        // return Math.max(ans, nums[0]*nums[1]*nums[size - 1]);
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1*max2*max3, max1*min1*min2);
    }
}
