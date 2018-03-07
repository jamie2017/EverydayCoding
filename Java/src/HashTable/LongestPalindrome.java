package HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by JMYE on 10/5/16.
 */
public class LongestPalindrome {
    public int longestPalindrome_set(String s) {
        if(s == null || s.length() == 0) return 0;
        HashSet<Character> hs = new HashSet<Character>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(hs.contains(s.charAt(i))){
                hs.remove(s.charAt(i));
                count++;
            }else{
                hs.add(s.charAt(i));
            }
        }
        if(!hs.isEmpty()) return count * 2 + 1;
        return count * 2;
    }


    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }
        int len = 0;
        boolean hasOdd = false;
        for (Character key : map.keySet()) {
            int check = map.get(key);
            if (check % 2 != 0) {
                len += check - 1;
                hasOdd = true;
            } else {
                len += check;
            }
        }
        return hasOdd ? len + 1 : len;
    }

    public static void main(String[] args) {
        String s = "wwwgwsgsgsw";
        LongestPalindrome test = new LongestPalindrome();
        System.out.println(test.longestPalindrome_set(s));
        System.out.println(test.longestPalindrome(s));
    }
}
