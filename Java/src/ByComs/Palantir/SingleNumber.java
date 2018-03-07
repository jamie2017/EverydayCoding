package ByComs.Palantir;

/**
 * Created by JMYE on 11/1/16.
 */
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int single = nums[0];
        for(int i = 1; i < nums.length; i++) {
            single ^= nums[i];
        }
        return single;
    }


    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,3,4,5,4,6,6,7,7,8,8,9,9};
        System.out.println(singleNumber(nums));
        System.out.println(5 ^ 5);
        System.out.println(0 ^ 0);
        System.out.println(0 ^ 1 ^ 0);
        System.out.println(0 ^ 1);
        System.out.println(0 ^ 10);

    }

}
