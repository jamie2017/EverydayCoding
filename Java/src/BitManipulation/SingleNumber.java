package BitManipulation;

/**
 * Created by JMYE on 8/28/16.
 */
public class SingleNumber { // XOR
    public int singleNumber(int[] nums) {
        int single = nums[0];
        for (int i = 1; i < nums.length; i++){
            single ^=nums[i];
        }
        return single;
    }

}
