package ByComs.Google;

/**
 * Created by jianmei on 7/5/16.
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) { // O(1)
        // 1162261467 is 3^19,  3^20 is bigger than int
        return (n > 0) && (1162261467 % n == 0);
    }
}
