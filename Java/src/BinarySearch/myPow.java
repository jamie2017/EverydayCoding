package BinarySearch;

/**
 * Created by jianmei on 7/6/16.
 */
public class myPow {
	public double myPow(double x, int n) { // Recusive
		double ans= 1;
		for(long i = Math.abs((long)n); i > 0; i = i >> 1, x *=x)
			if((i & 1) == 1) ans *= x;
		return n > 0 ? ans : 1/ans;
	}
}
