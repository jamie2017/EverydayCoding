package TwoPointer;

import java.util.Arrays;

/**
 * Created by JMYE on 9/5/16.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {

        // O(n^2)
        if (nums == null || nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int newSum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - newSum) < Math.abs(target - closestSum)) {
                    closestSum = newSum;
                }
                if (newSum < target) {
                    left ++;
                } else if (newSum > target) {
                    right --;
                } else {
                    return newSum;
                }
            }
        }
        return closestSum;
    }

}
