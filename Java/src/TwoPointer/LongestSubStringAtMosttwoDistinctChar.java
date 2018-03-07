package TwoPointer;

import java.util.HashSet;

/**
 * Created by JMYE on 9/6/16.
 */
public class LongestSubStringAtMosttwoDistinctChar {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int maxLen = 0;
        if (s == null || s.length() == 0) {
            return maxLen;
        }
        if (s.length() == 2) {
            return 2;
        }
        if (validString(s)) return s.length();

        int slow = 0, fast = 1;
        maxLen = 2;
        while (fast < s.length() - 1) {
            fast++;
            if(validString(s.substring(slow,fast+1))){
                maxLen = Math.max(maxLen,s.substring(slow,fast+1).length());
            } else {
                slow++;
            }
        }
        return maxLen;

    }

    private boolean validString(String s) {
        HashSet<Character> set = new HashSet<>();
        char[] s_char = s.toCharArray();
        for(char sc: s_char){
            if(!set.contains(sc)) {
                set.add(sc);
            }
            if (set.size() > 2) {
                return false;
            }
        }
        return true;
    }
}
