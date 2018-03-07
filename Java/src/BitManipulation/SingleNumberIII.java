package BitManipulation;

/**
 * Created by JMYE on 9/18/16.
 */
public class SingleNumberIII {
    public int[] singleNumberIII(int[] nums) {
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff; // !!!!

        // Pass 2 :
        int[] rst = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums)
        {
            if ((num & diff) == 0) // the bit is not set
            {
                rst[0] ^= num;
            }
            else // the bit is set
            {
                rst[1] ^= num;
            }
        }
        return rst;
    }
}
