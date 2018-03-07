package Math;

/**
 * Created by JMYE on 7/2/17.
 * 633. Sum of Square Numbers
 * Given a non-negative integer c,
 * your task is to decide whether there're two integers a and b
 * such that a2 + b2 = c.

 Example 1:
 Input: 5
 Output: True
 Explanation: 1 * 1 + 2 * 2 = 5

 Example 2:
 Input: 3
 Output: False
 */
public class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        for(int i = 0; i <= (int)Math.sqrt(c);i++) {
            if (isPerfectSquare(c - i*i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPerfectSquare(int N) {
         return Math.sqrt(N) == Math.floor(Math.sqrt(N));
//         or
//        return Math.pow((int)Math.sqrt(N),2) == N;
    }
}
