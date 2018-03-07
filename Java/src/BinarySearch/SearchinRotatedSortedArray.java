package BinarySearch;

/**
 * Created by JMYE on 9/13/16.
 */
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[start] < nums[mid]) {
                // situation 1, red line
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                // situation 2, green line
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return  -1;
    }

    public static void main(String[] args) {
        SearchinRotatedSortedArray test = new SearchinRotatedSortedArray();
        int[] nums = {7,7,8,8,8,1,2,3,4,5,5,6};
        int target = 7;
        System.out.println(test.search(nums,target));
    }
}
