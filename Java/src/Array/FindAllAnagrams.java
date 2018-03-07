package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 3/16/17.
 */
public class FindAllAnagrams {
    public List<String> findAllAnagrams(String needle, String haystack) {
        List<String> rst = new ArrayList<>();
        int[] charMap = new int[256];
        int targetCnt = 0, sourceCnt = 0;
        for (int i = 0; i < needle.length(); i++) {
            charMap[needle.charAt(i)] ++;
            sourceCnt++;
        }
        int start = 0;
        for (int i = 0; i < haystack.length();i++) {
            if (charMap[haystack.charAt(i)] > 0) {
                targetCnt++;
            }
            charMap[haystack.charAt(i)]--;
            while (sourceCnt == targetCnt) {
                if (i - start + 1 == needle.length()) {
                    rst.add(haystack.substring(start, i + 1));
                }
                charMap[haystack.charAt(start)]++;
                if (charMap[haystack.charAt(start)] > 0) {
                    targetCnt--;
                }
                start ++;
            }
        }
        return rst;

    }

    public static void main(String[] args) {
        FindAllAnagrams test = new FindAllAnagrams();
        String s1 = "sis";
        String s2 = "mississippi";
        System.out.println(test.findAllAnagrams(s1,s2));
    }
}
