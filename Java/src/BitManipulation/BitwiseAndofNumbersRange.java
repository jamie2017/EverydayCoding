package BitManipulation;

/**
 * Created by JMYE on 9/18/16.
 * 201. Bitwise AND of Numbers Range
 */
public class BitwiseAndofNumbersRange {
    /*

    1. last bit of (odd number & even number) is 0.
    2. when m != n, There is at least an odd number and an even number, so the last bit position result is 0.
    3. Move m and n rigth a position.

     */
    public int rangeBitwiseAnd(int m, int n) {
//        if (m == 0) {
//            return 0;
//        }
//        int moveFactor = 1;
//        while(m != n) {
//            m >>= 1;
//            n >>= 1;
//            moveFactor <<= 1;
//        }
//        return m * moveFactor;
        while (m < n) {
            n &= n - 1;
        }
        return n;
    }
}
