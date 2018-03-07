package HashTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 11/1/16.
 */
public class FindAllAnagramsinsString {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> rst = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return rst;

        int[] hash = new int[26];
        for (char c : p.toCharArray()) {
            hash[c - 'a']++;
        }
        int left = 0, right = 0, count = p.length(), window = p.length();
        while (right < s.length()) {
            if (hash[s.charAt(right) - 'a'] >=1) count--;
            hash[s.charAt(right) - 'a']--;
            right++;

            if (count == 0) rst.add(left);

            if (right - left == window) {
                if (hash[s.charAt(left) - 'a'] >= 0) count++;
                hash[s.charAt(left) - 'a']++;
                left++;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s,p));

    }
}

