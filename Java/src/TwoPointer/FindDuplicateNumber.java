package TwoPointer;

/**
 * Created by JMYE on 9/6/16.
 * 287. Find the Duplicate Number
 */
public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) { // O(nlgn)
        int low = 1, high = nums.length - 1;
        while (low <= high) {
            int mid = (int) (low + (high - low) * 0.5);
            int cnt = 0;
            for (int a : nums) { // here a iter through all nums ,includs mid
                if (a <= mid) cnt++;
            }
            if (cnt <= mid) low = mid + 1;
            else high = mid - 1;
        }
        return low;// because num >= 1, is not zero based
    }

    // find loop
    public int findDuplicate_loop(int[] nums) { // O(n)
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {6,2,1,5,2,4,3};
        FindDuplicateNumber test = new FindDuplicateNumber();
        System.out.println(test.findDuplicate(nums));
        System.out.println(test.findDuplicate_loop(nums));
    }
}
