package BinarySearch;

/**
 * Created by JMYE on 3/15/17.
 */
public class SingleElementInaSortedArray { // find the last pair of element appear twice, then *2 the index to find our answer
    public int singleNonDuplicate(int[] nums) {
        int lo = 0, hi = nums.length / 2;
        while (lo < hi) {
            int mi = (lo + hi)/2;
            if (nums[2 * mi] != nums[2 * mi + 1]) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }
        return nums[2 * lo];
    }

    public static void main(String[] args) {
        SingleElementInaSortedArray test = new SingleElementInaSortedArray();
//        int[] nums = {1,1,2}; // 2
//        int[] nums = {1,2,2}; // 1
//        int[] nums = {3,3,7,7,10,11,11};// 10
        int[] nums = {8,8,7,7,6,6,5}; // 5
        System.out.println(test.singleNonDuplicate(nums));
    }
}
