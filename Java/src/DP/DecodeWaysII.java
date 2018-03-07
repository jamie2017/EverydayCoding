package DP;

/**
 * Created by JMYE on 7/21/17.
 */
public class DecodeWaysII {
    public int numDecodings(String s) {
        int MOD = 1000000007;
        long[] dp = new long[3];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0: 1;
        for (int i = 1; i < s.length(); i++) {
            int twoDigit = 0;
            if (s.charAt(i) == '*') {
                dp[(i + 1) % 3] = 9 * dp[i % 3];
                if (s.charAt(i - 1) == '1') {
                    twoDigit = 9;
                } else if (s.charAt(i - 1) == '2') {
                    twoDigit = 6;
                } else if (s.charAt(i - 1) == '*') {
                    twoDigit = 15; // 9 + 6
                }
            } else {
                if (s.charAt(i) != '0') {
                    dp[(i + 1) % 3] = dp[i % 3];
                } else {
                    dp[(i + 1) % 3] = 0;
                }
                if (s.charAt(i - 1) == '1') {
                    twoDigit = 1;
                } else if (s.charAt(i - 1) == '2' && s.charAt(i) <= '6') {
                    twoDigit = 1;
                } else if (s.charAt(i - 1) == '*') { // 1*2 vs 1*7
                    twoDigit = s.charAt(i) <= '6' ? 2 : 1;
                }
            }
            dp[(i + 1) % 3] =  (dp[(i + 1) % 3]+ twoDigit * dp[(i - 1)%3]) % MOD;
        }
        return (int)dp[s.length() % 3];
    }

    public static void main(String[] args) {
        DecodeWaysII test = new DecodeWaysII();
        System.out.println(test.numDecodings("1111"));
        System.out.println(test.numDecodings("1101"));
    }
}
