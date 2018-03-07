package ByComs.SumoLogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//        int[] charMap = new int[256];
        Map<Character, Integer> charMap = new HashMap<>();
        int targetCnt = 0;
        for (int i = 0; i < needle.length(); i++) {
//            charMap[]++;
            char key = needle.charAt(i);
            charMap.put(key,charMap.getOrDefault(key,0) + 1);
            targetCnt ++;
        }
        int sourceCnt = 0;
        int start = 0;
        for (int i = 0; i < haystack.length(); i++ ) {
            if (charMap.getOrDefault(haystack.charAt(i),0) > 0) {
                sourceCnt ++;
            }
//            if (charMap[haystack.charAt(i)] > 0) {
//                sourceCnt ++;
//            }
            charMap.put(haystack.charAt(i),charMap.getOrDefault(haystack.charAt(i),0) - 1);

//            charMap[haystack.charAt(i)] --;
            while (targetCnt == sourceCnt) {
                if (i - start == needle.length() - 1) {
                    rst.add(haystack.substring(start, i + 1));
                }
                charMap.put(haystack.charAt(start),charMap.getOrDefault(haystack.charAt(start),0) + 1);
                if (charMap.getOrDefault(haystack.charAt(start),0) > 0) {
                    sourceCnt --;
                }
//                charMap[haystack.charAt(start)]++;
//                if (charMap[haystack.charAt(start)] > 0) {
//                    sourceCnt --;
//                }
                start ++;
            }

        }
        return rst;
    }

    public int findPermutationsII(String needle, String haystack) {
        int rst = 0;
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
                    rst++;
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
//        int cnt = test.findPermutationsII(s1,s2);
        System.out.println(rst);
//        System.out.println(cnt);
        s1 = "sis";
        s2 = "mississippi";
        rst = test.findPermutaions(s1,s2);
//        cnt = test.findPermutationsII(s1,s2);
        System.out.println(rst);
//        System.out.println(cnt);
        s1 = "abc";
        s2 = "abefcgsegbca";
        rst = test.findPermutaions(s1,s2);
//        cnt = test.findPermutationsII(s1,s2);
        System.out.println(rst);
//        System.out.println(cnt);


    }
    //('sis', 'mississippi') => ['iss', 'ssi', 'sis', 'iss', 'ssi']

//    Example: needle ="aba", haystack = "abaaabaca"
//    output =["aba", "baa", "aab", "aba"]

}
