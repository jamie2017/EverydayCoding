package Math;

/**
 * Created by JMYE on 9/14/16.
 */
public class Pow_x_n {

    public double myPow(double x, int n) { // x = 8.88023, n = 3 pow(x,n) =700.28148
        if(n == 0)
            return 1;
        if(n < 0){
            if(n == Integer.MIN_VALUE) return (1/x)*myPow(x, n+1); // -2147483648 ==> -2147483647
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
}
