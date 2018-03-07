package Backtracking;

/**
 * Created by JMYE on 9/15/16.
 */
public class CountNumberswithUniqueDigits {

    // not good
    public int countNumbersWithUniqueDigits(int n) {
        if (n > 10) {
            return countNumbersWithUniqueDigits(10);
        }

        int count = 1;
        long max = (long) Math.pow(10, n);
        boolean[] used = new boolean[10];
        for (int i = 1; i < 10; i++) {
            used[i] = true;
            count += search(i, max, used);
            used[i] = false;
        }

        return count;

    }

    private static int search(long prev, long max, boolean[] used) {
        int count = 0;
        if (prev < max) {
            count++;
        } else {
            return count;
        }

        for (int i = 0; i < 10; i++) {
            if (!used[i]) {
                used[i] = true;
                long cur = 10 * prev + i;
                count += search(cur,max, used);
                used[i] = false;
            }
        }

        return count;
    }

    // dp
    public int countNumbersWithUniqueDigits_DP(int n) {
        // Let f(k) = count of numbers with unique digits with length equals k.
        //f(1) = 10, ..., f(k) = 9 * 9 * 8 * ... (9 - k + 2) [The first factor is 9 because a number cannot start with 0]
        if (n == 0) return 1;
        if (n > 10) return countNumbersWithUniqueDigits_DP(10);
        int rst = 10;
        int uniqueDigits = 9;
        int availableNum = 9;
        while (n-- > 1 && availableNum > 0) {
            uniqueDigits = uniqueDigits * availableNum;
            rst += uniqueDigits;
            availableNum --;
        }
        return rst;
    }

    public int countNumbersWithUniqueDigits_dp2(int n) {
        if (n == 0) return 1;
        int res = 10, cnt = 9;
        for (int i = 2; i <= n; ++i) {
            cnt *= (11 - i);
            res += cnt;
        }
        return res;

    }


    public int countNumbersWithUniqueDigits_dp(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        if (n > 10) {
            n = 10;
        }

        // f[i]: how many valid rst when  ith Number ！= 0
        // g[i]: how many valid rst when ith Number == 0

        int[] f = new int[n + 1];
        int[] g = new int[n + 1];
        int rst = 10;
        g[0] = 1; // 0
        g[1] = 9; // 10,20,30,40,50,60,70,80,90
        for (int i = 2; i <= n; i++) {
            f[i] =  f[i - 1] * (9 - i + 2)  + g[i - 2] * (9 - i + 2);
            g[i] = g[i - 1] * (10 - i);
            rst += f[i] + g[i];
        }
        return rst;

    }


    public static void main (String[] args) {
        int n = 3;
        CountNumberswithUniqueDigits test = new CountNumberswithUniqueDigits();
        System.out.println(test.countNumbersWithUniqueDigits_dp(n));
    }


}
