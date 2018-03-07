package BitManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 11/27/16.
 */
public class MaximumSubarrayXOR {
    public static int maxiumSubarrayXOR(int[] nums){// subarray contains at least one element
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = 0;
        while (true) {
            int tmpMax = 0;
            for (int num : nums) { // find such a tmpMax that has the leading 1 in the array
                tmpMax = Math.max(tmpMax, num);
            }
            if (tmpMax == 0) break;
            ans = Math.max(ans, ans ^ tmpMax);
            for (int i = 0; i < nums.length; i++) { // eliminate
                nums[i] = Math.min(nums[i], nums[i] ^ tmpMax);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = {4,6}; // 6
        int[] nums = {4,2,1,3}; // 7
//        int[] nums = {1, 8, 2, 6, 7, 12}; // 15
//        int[] nums = {9,10,8};// 11
        System.out.println(maxiumSubarrayXOR(nums));

    }



}
