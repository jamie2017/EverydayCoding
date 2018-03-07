package Math;

/**
 * Created by JMYE on 9/14/16.
 * 397. Integer Replacement
 */
public class IntegerReplacement {
    public int integerReplacement(int n) {
        if(n == Integer.MAX_VALUE) return 32; //n = 2^31-1;
        int count = 0;
        while(n > 1){
            if(n % 2 == 0){
                n /= 2;
            } else {
                if ((n+1) % 4 == 0 && (n-1 != 2)) {
                    n += 1;
                } else {
                    n -= 1;
                }
            }
            count++;
        }
        return count;

    }
}
