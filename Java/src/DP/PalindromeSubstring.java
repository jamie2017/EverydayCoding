package DP;


/**
 * Created by JMYE on 7/24/17.
 */
public class PalindromeSubstring {
    int count;
    public int countSubstrings(String s) {
        count = 0;
        for (int i = 0; i < s.length(); i++) {
            expandAroundCenter(s, i, i);
            expandAroundCenter(s, i, i + 1);
        }
        return count;
    }

    private void expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
            count++;
        }
    }

    public static void main(String[] args) {
        PalindromeSubstring test = new PalindromeSubstring();
        System.out.println(test.countSubstrings("abc"));
        System.out.println(test.countSubstrings("aaa"));

    }
}
