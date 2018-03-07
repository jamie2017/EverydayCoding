package Math;

/**
 * Created by JMYE on 8/27/16.
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        for (int i = 2; i < 6 && num > 0; i++) {
            while (num % i == 0) {
                num /= i;
            }
        }
        return num == 1;


    }
    public boolean isPrime(int num) {
        if (num < 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
