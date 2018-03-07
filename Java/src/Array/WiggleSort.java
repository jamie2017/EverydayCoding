package Array;

import java.util.Arrays;

/**
 * Created by JMYE on 10/2/16.
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) { // O(nlogn)
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i += 2) {
            swap(nums, i, i + 1);
        }
    }
    public void wiggleSort_1pass(int[] nums) { // one pass O(n)
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i % 2 == 0) == (nums[i] > nums[i + 1])) { // !!!!! TOO SMART!!!
                swap(nums, i, i + 1);
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
