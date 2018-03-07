package BitManipulation;

/**
 * Created by JMYE on 9/18/16.
 */
public class SingleNumberII { // mark
    public int singleNumberII(int[] A) {
        int ones = 0, twos = 0;
        for(int i = 0; i < A.length; i++){
            ones = (ones ^ A[i]) & ~twos;
            twos = (twos ^ A[i]) & ~ones;
        }
        return ones;
    }

    public int singleNumber2(int[] A) {
        int ones = 0;
        int twos = 0;
        int threes;
        for (int i = 0; i < A.length; i++) {
            int tmp = A[i];
            twos |= ones & tmp;
            ones ^= tmp;
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }

    public int singleNumberIINonBit(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int result=0;
        int[] bits=new int[32];
        for (int i = 0; i < 32; i++) {
            for(int j = 0; j < A.length; j++) {
                bits[i] += A[j] >> i & 1;
                bits[i] %= 3;
            }

            result |= (bits[i] << i);
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums = {-2,-2,1,1,-3,1,-3,-3,-4,-2};
        SingleNumberII test = new SingleNumberII();
        System.out.println(test.singleNumberIINonBit(nums)); // -4
    }
}
