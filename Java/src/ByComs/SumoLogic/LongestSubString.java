package ByComs.SumoLogic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JMYE on 6/16/17.
 */
public class LongestSubString {
    // LC3 return longest substring without repeat
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        if (s == null || s.length() == 0) {
            return maxLen;
        }
        Map<Character, Integer> charMap = new HashMap<>();
        int validStart = -1;
        String lss = "";
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (charMap.containsKey(cur)) {
                validStart = Math.max(validStart, charMap.get(cur)); // abba
            }
            if (i - validStart > maxLen) {
                maxLen = i - validStart;
                lss = s.substring(validStart + 1, i + 1);
            }
            charMap.put(cur,i);
        }
        System.out.println(lss);
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubString test = new LongestSubString();
        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(test.lengthOfLongestSubstring("bbbbb"));
        System.out.println(test.lengthOfLongestSubstring("pwwkew"));

    }
}
