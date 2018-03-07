package String;

/**
 * Created by JMYE on 10/5/16.
 */
public class LongestSubstringAtLeastKTimes { // smart
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if (n == 0 || n < k) return 0;
        if (k == 1) return n;
        int[] counts = new int[26];
        for (char c: s.toCharArray()) counts[c - 'a']++;
        boolean valid = true;
        char badchar = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0 && counts[i] < k) {
                badchar = (char)(i + 'a');
                break;
            }
        }
        if (badchar == 0) return n;
        String[] subs = s.split(badchar + "");
        int res = 0;
        for (String sub:subs) res = Math.max(res, longestSubstring(sub,k));
        return res;
    }
}
