package BitManipulation;

/**
 * Created by JMYE on 10/1/16.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int rst = 0;
        for (int i  = 1; i <= nums.length; i++) {
            rst ^= i;
        }
        for (int num : nums) {
            rst ^= num;
        }
        return rst;
    }
}
