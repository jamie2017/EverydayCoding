package BitManipulation;

/**
 * Created by JMYE on 9/22/16.
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        return (Math.log(num) / Math.log(4)) % 1 == 0;

        // return Integer.toString(num, 4).matches("10*");

        //return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
        //0x55555555 is to get rid of those power of 2 but not power of 4
        //so that the single 1 bit always appears at the odd position
    }
}
