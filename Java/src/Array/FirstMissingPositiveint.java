package Array;

/**
 * Created by JMYE on 9/12/16.
 */
public class FirstMissingPositiveint { // O(n) , constant space !!! Smart
    public int FirstMissingPositiveint(int[] nums) {
        if (nums == null) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != (i + 1)) {
                int tmp = nums[nums[i] - 1];
                if (tmp == nums[i]) {
                    break;
                }
                nums[nums[i] - 1] = nums[i];     // put num[i] back to where it should belong to
                nums[i] = tmp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println("+++++++++");
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositiveint test = new FirstMissingPositiveint();
        int[] nums1 = {30,24,7,8};
        System.out.println(test.FirstMissingPositiveint(nums1));
        int[] nums2 = {2,3,1,-1};
        System.out.println(test.FirstMissingPositiveint(nums2));
    }
}
