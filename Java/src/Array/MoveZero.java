package Array;

/**
 * Created by JMYE on 6/7/16.
 */
public class MoveZero {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int count = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == 0) {
                count ++;
            } else{
                nums[i - count] = nums[i];
            }
            i ++;
        }
        for (i = n - count; i < n; i++) {
            nums[i] = 0;
        }

    }
    public static void main (String[] argu) {
        int[] nums = {0,0,2,1,4,0,3,0,2,0,6};
        MoveZero test = new MoveZero();
        test.moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ,");
        }

    }
}
