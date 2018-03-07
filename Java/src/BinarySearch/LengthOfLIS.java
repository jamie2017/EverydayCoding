package BinarySearch;

import java.util.Arrays;

/**
 * Created by JMYE on 9/17/16.
 */
public class LengthOfLIS { // MARK!

    /*

    Given [10, 9, 2, 5, 3, 7, 101, 18],
    return 4 ([2, 3, 7, 101])
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int len = 0;
        for (int i = 1; i < nums.length;i++) {
            int pos = binarySearch(dp, len, nums[i]);
            if (nums[i] < dp[pos]) dp[pos] = nums[i];
            if (pos > len) {
                len = pos;
                dp[len] = nums[i];
            }
        }
        return len + 1;
    }

    private int binarySearch(int[] dp, int len, int val) {
        int left = 0, right = len;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (dp[mid] == val) {
                return mid;
            } else {
                if (dp[mid] < val) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }

        if (dp[right] < val) return len + 1;
        else if (dp[left] >= val) return left;
        else return right;
    }


    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
}
