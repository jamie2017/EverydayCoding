package HandleDuplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JMYE on 7/27/17.
 * 645. Set Mismatch
 */
public class FindErrorNums {
    public int[] findErrorNums(int[] nums) {
//        // O(n) O(n) one pass use hashset
//        int n = nums.length;
//        Set<Integer> numSet = new HashSet<>();
//        int totalSum = (n * (n + 1))/2;
//        int[] ans = new int[2];
//        for (int num : nums) {
//            if (numSet.contains(num)) {
//                ans[0] = num;
//            }
//            totalSum -= num;
//            numSet.add(num);
//        }
//        ans[1] = totalSum + ans[0];
//        return ans;

        // O(n) O(1) two pass
        int[] ans = new int[2];
        for (int num: nums) {
            if (nums[Math.abs(num) - 1] < 0) {
                ans[0] = Math.abs(num);
            } else {
                nums[Math.abs(num) - 1] *= -1;
            }
        }
        for (int i = 0; i < nums.length;i ++) {
            if (nums[i] > 0) {
                ans[1] = i + 1;
            }
        }
        return ans;
    }
}
