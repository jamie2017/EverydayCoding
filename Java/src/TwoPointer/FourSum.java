package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by JMYE on 9/5/16.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        Arrays.sort(nums);
        int left,right;
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                left = j + 1;
                right = nums.length - 1;
                twoSum(nums,target,nums[i],nums[j],left,right,ans);
            }
        }
        return ans;
    }

    private void twoSum(int[] nums,int target, int a, int b, int left, int right, List<List<Integer>> ans) {
        while (left < right && right < nums.length) {
            int candidate = a + b + nums[left] + nums[right];
            if (candidate > target) {
                right--;
            } else if (candidate < target) {
                left ++;
            } else {
                ans.add(Arrays.asList(a,b,nums[left],nums[right]));
                while(left < right && nums[left] == nums[left + 1]) left++;
                while(left < right && nums[right] == nums[right - 1]) right--;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] S = {1,0,-1,0,-2,2};
        int target = 0;
        FourSum test = new FourSum();
        System.out.println(test.fourSum(S,target));
    }
}
