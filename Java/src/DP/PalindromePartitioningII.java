package DP;

/**
 * Created by JMYE on 9/25/16.
 */
public class PalindromePartitioningII {
    // f[i] 表示前i个字母，最少被切割几次可以切割为都是回文串。
    // 最后return f[n]
    // f[i] = min(f[i], f[j] + 1)
    // Init: f[i] = i - 1;


    private boolean[][] getIsPalindrome(String s) { // SMART
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }

        for (int length = 2; length < s.length(); length++) {
            for (int start = 0; start + length < s.length(); start++) {
                isPalindrome[start][start + length]
                        = isPalindrome[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length);
            }
        }

        return isPalindrome;
    }

    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // preparation
        boolean[][] isPalindrome = getIsPalindrome(s);

        // initialize
        int[] f = new int[s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            f[i] = i - 1;
        }

        // main
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }

        return f[s.length()];
    }


    public static void main(String[] args) {
        String s = "abbab";
        PalindromePartitioningII test = new PalindromePartitioningII();
        System.out.println(test.minCut(s));
    }
}
