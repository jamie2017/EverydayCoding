package BitManipulation;

/**
 * Created by JMYE on 9/22/16.
 */
public class PowerOfTwo {
    // power of two means 2^0,2^1,2^2,2^3,....
    // 1,2,4,8,16,....
    // if they're in binary form has and only has one '1'
    // 100 & 011 == 0
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
        // return n>0 && Integer.bitCount(n) == 1;
    }
    public static void main (String[] argu) {
        PowerOfTwo test = new PowerOfTwo();
        System.out.println(test.isPowerOfTwo(1));
    }
}
