package Math;

/**
 * Created by JMYE on 9/10/16.
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
    public int trailingZeroes_iter(int n) {
        if(n<5) return 0;
        int k=  (int) (Math.log(n) / Math.log(5));
        int sum=0;
        while(k>0)
        {
            sum+=n/Math.pow(5,k--);
        }

        return sum;
    }
}
