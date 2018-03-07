package Math;

/**
 * Created by JMYE on 9/25/16.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int y = x;
        int rst = 0;
        while ( y != 0) {
            rst = 10 * rst + y % 10;
            y = y / 10;
        }

        return rst == x;
    }
}
