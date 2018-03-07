package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by JMYE on 9/5/16.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if (nums == null ) {
            return rst;
        }
        int target;
        int left;
        int right;
        for (int i = 0; i < nums.length - 2; i++) {
            // NOTE
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                target = nums[i];
                left = i + 1;
                right = nums.length - 1;
                if (target > 0 && nums[left] > 0 || target < 0 && nums[right] < 0) break;
                twoSum(nums, target, left, right, rst);
            }
        }
        return rst;
    }

    private void twoSum(int[] nums, int target, int left, int right, List<List<Integer>> rst) { // nums here already sorted
        int targetwithSign = target * (-1); // 0 - target;
        List<Integer> tmpResult;
        while (left < right) {
            if (nums[left] + nums[right] > targetwithSign) {
                right --;
            } else if (nums[left] + nums[right] < targetwithSign) {
                left ++;
            } else {
                tmpResult = new ArrayList<>();
                tmpResult.add(nums[left]);
                tmpResult.add(nums[right]);
                tmpResult.add(target);
                rst.add(tmpResult);
                while (left < right && nums[left] == nums[left + 1]) left++; // NOTE
                while (left < right && nums[right] == nums[right - 1]) right--; // NOTE
                left ++;
                right --;
            }
        }
    }
}
