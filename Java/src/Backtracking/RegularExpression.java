package Backtracking;

/**
 * Created by JMYE on 9/15/16.
 */
public class RegularExpression {
    /*

    1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
    2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
    3, If p.charAt(j) == '*':
            here are two sub conditions:
               1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
               2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
     */
    public boolean isMatch_DP(String s, String p) {

        boolean[][] state = new boolean[s.length() + 1][p.length() + 1];
        state[0][0] = true;

        // no need to initialize state[i][0] as false
        // initialize state[0][j]

        for (int j = 1; j < state[0].length; j++) {
            if (p.charAt(j - 1) == '*') {
                if (state[0][j - 1] || (j > 1 && state[0][j - 2])) {
                    state[0][j] = true;
                }
            }
        }

        for (int i = 1; i < state.length; i++) {
            for (int j = 1; j < state[0].length; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    state[i][j] = state[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        state[i][j] = state[i][j - 2];
                    } else {
                        state[i][j] = state[i - 1][j] || state[i][j - 1] || state[i][j - 2];
                    }
                }
            }
        }
        return state[s.length()][p.length()];
    }



    // Backtracking
    public boolean isMatch(String s, String p) {
        for (int i = 0; i < p.length(); s = s.substring(1)) {
            char c = p.charAt(i);
            if (i + 1 >= p.length() || p.charAt(i + 1) != '*') {
                i++;
            } else if (isMatch(s,p.substring(i + 2))) {
                return true;
            }

            if (s.isEmpty() || (c != '.' && c != s.charAt(0))){
                return false;
            }
        }

        return s.isEmpty();
    }

    public boolean isMatch2(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        if (p.length() == 1 || p.charAt(1) != '*') {
            if (s.isEmpty() || (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0))) {
                return false;
            } else {
                return isMatch(s.substring(1), p.substring(1));
            }
        }

        //P.length() >=2
        while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            s = s.substring(1);
        }

        return isMatch(s, p.substring(2));
    }

    public static void main(String[] argu) {
        RegularExpression test = new RegularExpression();
//        String s = "aa", p = "a*";
//        String s = "aab", p = "c*a*b";
        String s = "", p = ".*";
        System.out.println(test.isMatch_DP(s,p));
    }
}
