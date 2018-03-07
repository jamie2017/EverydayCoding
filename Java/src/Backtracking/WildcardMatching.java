package Backtracking;

/**
 * Created by JMYE on 9/15/16.
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int str = 0, pattern = 0, match = 0, starIdx = -1;
        while (str < s.length()) {
            if (pattern < p.length() && (p.charAt(pattern) == '?' || s.charAt(str) == p.charAt(pattern))) {
                str++;
                pattern++;
            }
            else if (pattern < p.length() && p.charAt(pattern) == '*') {
                starIdx = pattern;
                match = str;
                pattern++;
            }
            else if (starIdx != -1) {
                pattern = starIdx + 1;
                match ++;
                str = match;
            }
            else {
                return false;
            }
        }

        while (pattern < p.length() && p.charAt(pattern) == '*') {
            pattern++;
        }
        return pattern == p.length();

    }
}
