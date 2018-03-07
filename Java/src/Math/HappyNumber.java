package Math;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JMYE on 8/27/16.
 */
// 202. Happy Number
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> inLoop = new HashSet<>();
        int squareSum, remainder;
        while (inLoop.add(n)) {
            squareSum = 0;
            while (n > 0) {
                remainder = n % 10;
                squareSum += remainder * remainder;
                n = n / 10;
            }
            if (squareSum == 1) {
                return true;
            }
            else {
                n = squareSum;
            }
        }
        return false;
    }
}
