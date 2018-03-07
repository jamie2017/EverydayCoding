package Backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by JMYE on 9/15/16.
 */
public class WordPatternII {
//    Map<Character, String> map = new HashMap<>();
//
//    public boolean wordPatternMatch(String pattern, String str) {
//        if (pattern.length() == 0) {
//            return str.length() == 0;
//        }
//
//        if (map.containsKey(pattern.charAt(0))) {
//            String value = map.get(pattern.charAt(0));
//            if (value.length() > str.length() || !str.substring(0,value.length()).equals(value)) {
//                return false;
//            }
//            if (wordPatternMatch(pattern.substring(1),str.substring(value.length()))) {
//                return true;
//            }
//        } else {
//            for (int i = 1; i <= str.length(); i++) {
//                if (map.containsValue(str.substring(0,i))) continue;
//                map.put(pattern.charAt(0), str.substring(0,i));
//                if (wordPatternMatch(pattern.substring(1), str.substring(i))) {
//                    return true;
//                }
//                map.remove(pattern.charAt(0));
//            }
//        }
//        return false;
//    }
    // Same as Word Pattern I use HashMap to ensure key unique, use set to ensure value unqiue
    // But not " " anymore, so need to apply backtracking to try different possibility
    // pattern start from i = 0, but every time only increase 1 because the key is one character a time
    // str start from j = 0, but the length of every value might be different due to different pattern matching

    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        return isMatch(str, 0, pattern, 0, map, set);
    }

    boolean isMatch(String str, int i, String pat, int j, Map<Character, String> map, Set<String> set) {
        // base case
        if (i == str.length() && j == pat.length()) return true;
        if (i == str.length() || j == pat.length()) return false;

        // get current pattern character
        char c = pat.charAt(j);

        // if the pattern character exists
        if (map.containsKey(c)) {
            String s = map.get(c);

            // then check if we can use it to match str[i...i+s.length()]
            if (!str.startsWith(s, i)) {
                return false;
            }

            // if it can match, great, continue to match the rest
            return isMatch(str, i + s.length(), pat, j + 1, map, set);
        }

        // pattern character does not exist in the map
        for (int k = i; k < str.length(); k++) {
            String p = str.substring(i, k + 1);

            if (set.contains(p)) {
                continue;
            }

            // create or update it
            map.put(c, p);
            set.add(p);

            // continue to match the rest
            if (isMatch(str, k + 1, pat, j + 1, map, set)) {
                return true;
            }

            // backtracking
            map.remove(c);
            set.remove(p);
        }

        // we've tried our best but still no luck
        return false;
    }

}
