package String;

/**
 * Created by JMYE on 5/10/17.
 * 567. Permutation in String
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        char[] charMap = new char[128];
        for (int i = 0; i < s1.length(); i++){
            charMap[s1.charAt(i) - 'a']++;
        }
        int targetCnt = s1.length();
        int sourceCnt = 0;
        int start = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (charMap[s2.charAt(i) - 'a'] > 0) {
                sourceCnt ++;
            }
            charMap[s2.charAt(i) - 'a']--;
            while (targetCnt == sourceCnt) {
                if (i - start + 1 == targetCnt) {
                    return true;
                }
                charMap[s2.charAt(start) - 'a']++;
                if (charMap[s2.charAt(start) - 'a'] > 0) {
                    sourceCnt --;
                }
                start++;
            }
        }
        return targetCnt == 0;
    }

    public boolean checkInclusion2(String s1, String s2) {
        char[] charMap = new char[128];
        for (int i = 0; i < s1.length(); i++){
            charMap[s1.charAt(i)]++;
        }
        int targetCnt = s1.length();
        int sourceCnt = 0;
        int left = 0, right = 0;
        while (right < s2.length()) {
            if (charMap[s2.charAt(right)] > 0) {
                sourceCnt++;
            }
            charMap[s2.charAt(right)]--;
            right++;
            if (sourceCnt == targetCnt) {
                return true;
            }
            if (right - left == targetCnt) {
                charMap[s2.charAt(left)]++;
                if (charMap[s2.charAt(left)] > 0) {
                    sourceCnt--;
                }
                left++;
            }
        }
        return targetCnt == 0;
    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        PermutationInString test = new PermutationInString();
        System.out.println(test.checkInclusion(s1,s2));
    }
}
