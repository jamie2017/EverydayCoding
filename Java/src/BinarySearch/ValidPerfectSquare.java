package BinarySearch;

/**
 * Created by JMYE on 9/17/16.
 */
public class ValidPerfectSquare {
    /*
    1.a square number is 1+3+5+7+... Time Complexity O(sqrt(N))
    Let x be the number of iterations needed to solve the problem,
    and let Σ be the sum from i = 1 to x. Σ(1 + 2i) = n => x + 2Σi = n
    => x + 2(x(x+1)) = n => 2x^2 + 3x = n => x = [-3 +/- sqrt(9 + 8n)]/4
    => you can see that n is in a square root term,
    so the complexity should be O(sqrt(n)).


    2.binary search. Time Complexity O(logN)

    3.Newton Method. See [this wiki page][1].
     Time Complexity is close to constant,
     given a positive integer.
     */

    public boolean isPerfectSquare1(int num) { // O(sqrt(n))
        if (num < 1) return false;
        for (int i = 1; num > 0; i += 2) {
            num -= i;
        }
        return num == 0;
    }

    public boolean isPerfactSquare2(int num) {
        if (num < 1) return false;
        long left = 1, right = num;// long type to avoid 2147483647 case

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long t = mid * mid;
            if (t > num) {
                right = mid - 1;
            } else if (t < num) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }

    public boolean isPerfectSquare3(int num) {
        if (num < 1) return false;
        long t = num ;
        while (t * t > num) {
            t = (t + num / t) / 2;
        }
        return  t * t == num;
    }
}
