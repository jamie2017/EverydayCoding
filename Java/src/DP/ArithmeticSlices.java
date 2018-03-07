package DP;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JMYE on 11/24/16.
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int curr = 0, sum = 0;
        for (int i = 2; i < A.length; i++)
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                curr += 1;
                sum += curr;
            } else {
                curr = 0;
            }
        return sum;
    }


    public int numberOfArithmeticSlices2(int[] A) {
        /*
        total = 0
        dp = [defaultdict(int) for item in A]
        for i in xrange(len(A)):
            for j in xrange(i):
                dp[i][A[i] - A[j]] += 1
                if A[i] - A[j] in dp[j]:
                    dp[i][A[i] - A[j]] += dp[j][A[i] - A[j]]
                    total += dp[j][A[i] - A[j]]
        return total
         */
        int total = 0;
        Map<Integer, Integer>[] dp = new HashMap[A.length];
        for (int i = 0; i < A.length; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                if((long)A[i]-A[j]>Integer.MAX_VALUE) continue;
                if((long)A[i]-A[j]<Integer.MIN_VALUE) continue;
                int key = A[i] - A[j];
                dp[i].put(key, dp[i].getOrDefault(key,0) + 1);
                if (dp[j].containsKey(key)) {
                    dp[i].put(key,dp[i].get(key)+ dp[j].get(key));
                    total += dp[j].get(key);
                }
            }
        }
        return total;


    }
    public static void main(String[] args) {
        int[] A = {2,4,6,8,10};
        ArithmeticSlices test = new ArithmeticSlices();
        System.out.println(test.numberOfArithmeticSlices(A));
        System.out.println(test.numberOfArithmeticSlices2(A));

    }
}
