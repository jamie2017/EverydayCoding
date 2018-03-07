package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JMYE on 9/22/16.
 */
public class LongestSubStringwithatMostKDistinctCharacters {
    public String lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] map = new int[256];
        int num = 0, i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {

            if (map[s.charAt(j)]++ == 0) num++;
            if (num > k) {
                while (--map[s.charAt(i++)] > 0); // 1)-- 2)> 3)++
                // !!! Tricky here, after this "while"
                // map only contains two valid characters

//                System.out.println(s.charAt(i));
//                System.out.println(map[s.charAt(i)]);
//                System.out.println(i);

//                do {
//                    map[s.charAt(i)]--;
//                } while (map[s.charAt(i++)] > 0);


                //
                num--;
            }

            res = Math.max(res, j - i + 1);
        }
        return s.substring(i,res);
    }
    public String  lengthOfLongestSubstringTwoDistinct(String s, int k) {
//        if(s.length() < 1) return ;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int lo = 0;
        int hi = 0;
        int maxLength = 0;
        String ans = null;
        while(hi < s.length()) {
            if(map.size() <= k) {
                char c = s.charAt(hi);
                map.put(c, hi);
                hi++;
            }
            if(map.size() > k) {
                int leftMost = s.length();
                for(int i : map.values()) {
                    leftMost = Math.min(leftMost,i);
                }
                char c = s.charAt(leftMost);
                map.remove(c);
                lo = leftMost+1;
            }
            if ((hi - lo) > maxLength) {
                maxLength = hi -lo;
                ans = s.substring(lo,hi);
            }
        }
        System.out.println(s);
        return ans;
    }


    public static void main(String[] args) {
        String s = "aababaaacacacccccadefab";
        LongestSubStringwithatMostKDistinctCharacters test = new LongestSubStringwithatMostKDistinctCharacters();
        System.out.println(test.lengthOfLongestSubstringTwoDistinct(s,2));
    }
}
