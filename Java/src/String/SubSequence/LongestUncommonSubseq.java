package String.SubSequence;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by JMYE on 7/7/17.
 *
 */
public class LongestUncommonSubseq {
    //521. Longest Uncommon Subsequence I

    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }


    // 522. Longest Uncommon Subsequence II
    public int findLUSlengthII(String[] strs) {
//        Arrays.sort(strs, (String a, String b)-> a.length() - b.length());
        Arrays.sort(strs, Comparator.comparing(String::length));
//        System.out.println(Arrays.asList(strs));
        for (int i = strs.length - 1; i >= 0; i--) {
            String s = strs[i];
            int subseqSum = 0;
            for (String t: strs) {
                if (isSubsequence(s,t)) {
                    subseqSum++;
                }
            }
            if (subseqSum == 1) return s.length();
        }
        return -1;
    }

    private boolean isSubsequence(String s, String t) {
        // check if s is t's subsequence
        if (s == null) {
            return true;
        }
        if (t == null) {
            return false;
        }
        if (s.length() > t.length()) {
            return false;
        }
        int sIdx = 0, tIdx = 0;
        while (tIdx < t.length()) {
            if (s.charAt(sIdx) == t.charAt(tIdx)) {
                sIdx++;
                if (sIdx == s.length()) {
                    return true;
                }
            }
            tIdx++;
        }
        return false;
    }
    public static void main(String[] args) {
        LongestUncommonSubseq test = new LongestUncommonSubseq();
        String a = "abc";
        String b = "abd";
        System.out.println(test.findLUSlength(a,b) == 3);
        a = "jamie";
        b = "jianmeiye";
        System.out.println(test.findLUSlength(a,b) == 9);

        String[] strs = {"jamie","ye","jianmei","jianmeiye"};
        System.out.println(test.findLUSlengthII(strs));


    }
}
