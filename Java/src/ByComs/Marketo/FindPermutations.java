package ByComs.Marketo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 5/10/17.
 *  Similar to 438. Find All Anagrams in a String
 */
public class FindPermutations {
    /**
     *
     * @param needle
     * @param haystack
     * @return
     */
    public List<String> findPermutaions(String needle, String haystack) {
        List<String> rst = new ArrayList<>();
        int[] charMap = new int[256];
        int targetCnt = 0;
        for (int i = 0; i < needle.length(); i++) {
            charMap[needle.charAt(i)]++;
            targetCnt ++;
        }
        int sourceCnt = 0;
        int start = 0;
        for (int i = 0; i < haystack.length(); i++ ) {
            if (charMap[haystack.charAt(i)] > 0) {
                sourceCnt ++;
            }
            charMap[haystack.charAt(i)] --;
            while (targetCnt == sourceCnt) {
                if (i - start == needle.length() - 1) {
                    rst.add(haystack.substring(start, i + 1));
                }
                charMap[haystack.charAt(start)]++;
                if (charMap[haystack.charAt(start)] > 0) {
                    sourceCnt --;
                }
                start ++;
            }

        }
        return rst;
    }

    public static void main(String[] args) {

        FindPermutations test = new FindPermutations();
        // List<String> rst = test.generateParentheses(n);

//         String s1 = "sis";
//         String s2 = "mississippi";
        // String s1 = "abc";
        // String s2 = "cabbac";
//        String s1 = "abcd";
//        String s2 = "cab";
        String s1 = "aba";
        String s2 = "abaaabaca";
        List<String> rst = test.findPermutaions(s1,s2);
        System.out.println(rst);

    }
    //('sis', 'mississippi') => ['iss', 'ssi', 'sis', 'iss', 'ssi']

//    Example: needle ="aba", haystack = "abaaabaca"
//    output =["aba", "baa", "aab", "aba"]

}
