package Array;

import java.util.Arrays;

/**
 * Created by JMYE on 6/2/16.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length;j++) {// Should start at 0, for case that val is the first number
            if (val != nums[j]) {
                nums[i] = nums[j];
                i ++;
            }
        }
        return i ;
    }

    public int removeElementII(int[] nums, int val) {// when elements to remove are rare
        int i = 0;
        int n = nums.length;
        while (i < n) {

            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }

        }
        return n;
    }
    public static void main (String[] argu) {
        RemoveElement test = new RemoveElement();
        int[] nums = {1,2,3,4,4,4,4,4,4,4,5,4,4,4,4};
        System.out.println(test.removeElement(nums,4));
        test.removeElementII(nums,4);
    }

}
