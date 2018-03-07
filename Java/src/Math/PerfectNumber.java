package Math;

/**
 * Created by JMYE on 3/31/17.
 */
public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int perfectSum = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                System.out.println(i + " " + num/i);
                perfectSum += i + num/i;
            }
        }
        return perfectSum == num;
    }
}
