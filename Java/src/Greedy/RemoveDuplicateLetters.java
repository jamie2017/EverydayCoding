package Greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JMYE on 9/24/16.
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        // Eg. s = "cbacdcbc"
        if (s == null || s.length() <= 1) return s;
        Map<Character, Integer> lastPosMap = new HashMap<>();
        // find the last entry of each letter
        for (int i = 0; i < s.length();i++) {
            lastPosMap.put(s.charAt(i),i);
        }
        // lastPosMap = {'c': 7,
        //               'b': 6,
        //               'd': 4,
        //               'a': 2}
        char[] rst = new char[lastPosMap.size()];
        // s = "cbacdcbc"
        // findMinLastPos() is to find the index of 'a'
        // end = 2;
        int begin = 0, end = findMinLastPos(lastPosMap);

        for (int i = 0; i < rst.length; i++) {
            char minChar = 'z' + 1; // function like Integer.MAX_VALUE to find minimal
            for (int k = begin; k <= end; k++) {
                if (lastPosMap.containsKey(s.charAt(k)) && s.charAt(k) < minChar) {
                    minChar = s.charAt(k);
                    begin = k + 1; // !! so that next time only compare start after last end
                }
            }

            rst[i] = minChar;// rst[0] = 'a'
            if (i == rst.length - 1) break;

            lastPosMap.remove(minChar);
            // lastPosMap = {'c': 7,
            //               'b': 6,
            //               'd': 4}
            if (s.charAt(end) == minChar) { // if minChar is last one of the letter,
                                            // then it will not need to be compare in the next round
                end = findMinLastPos(lastPosMap);
            }
        }
        return new String(rst);
    }

    private int findMinLastPos(Map<Character, Integer> lastPosMap) {
        if (lastPosMap == null || lastPosMap.isEmpty()) return -1;
        int minLastPos = Integer.MAX_VALUE;
        for (int lastPos : lastPosMap.values()) {
            minLastPos = Math.min(minLastPos,lastPos);
        }
        return minLastPos;
    }

    public static void main(String[] args) {
        String s = "cbacdcbc";
        RemoveDuplicateLetters test = new RemoveDuplicateLetters();
        System.out.println(test.removeDuplicateLetters(s));
    }
}
