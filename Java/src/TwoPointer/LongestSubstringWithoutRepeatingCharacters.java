package TwoPointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JMYE on 9/3/16.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int ans = 0, j = 0;
        for (int i = 0; i < s.length(); i++) { // O(n^2)
            while (j < s.length()) {
                if (s.substring(i, j).indexOf(s.charAt(j)) == -1) {
                    ans = Math.max(ans, j - i + 1);
                    j++;
                } else {
                    break;
                }
            }
        }
        return ans;

    }

    public int lengthOfLongestSubstringOpt(String s) {
        int n = s.length(), maxLen = 0;
        String ans = null;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j)) && i <= map.get(s.charAt(j))) {
                i = map.get(s.charAt(j)) + 1;
            }
            if (maxLen < j - i + 1) {
                maxLen = j - i + 1;
                ans = s.substring(i,j + 1);
            }
            map.put(s.charAt(j),j);
        }
        System.out.println(ans);
        return maxLen;
    }


    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(test.lengthOfLongestSubstringOpt("abcabcbb"));
        System.out.println(test.lengthOfLongestSubstringOpt("bbbbb"));
        System.out.println(test.lengthOfLongestSubstringOpt("pwwkew"));



    }
       /*
//        use map
        int[] map = new int[256];
        Arrays.fill(map,0);

        int j = 0;
        int i = 0;
        int ans = 0;
        for (i = 0; i < s.length(); i++) {
            while (j < s.length() && map[s.charAt(j)] == 0) {
                map[s.charAt(j)] = 1;
                ans = Math.max(ans, j - i + 1);
                j++;
            }
            map[s.charAt(i)] = 0;
        }
        return ans;
    }

    */

    /*
    int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
     */
}
