package DP;

/**
 * Created by JMYE on 9/5/16.
 */
public class LongestPalidromicSubstring { // MARK!!!
    // Solution 1
//    public String longestPalindrome(String s) {
//        if (s == null || s.length() == 0) {
//            return "";
//        }
//
//        int length = s.length();
//        int max = 0;
//        String result = "";
//        for(int i = 1; i <= 2 * length - 1; i++){
//            int count = 1;
//            while(i - count >= 0 && i + count <= 2 * length  && get(s, i - count) == get(s, i + count)){
//                count++;
//            }
//            count--; // there will be one extra count for the outbound #
//            if(count > max) {
//                result = s.substring((i - count) / 2, (i + count) / 2);
//                max = count;
//            }
//        }
//
//        return result;
//    }
//
//    private char get(String s, int i) {
//        if(i % 2 == 0)
//            return '#';
//        else
//            return s.charAt(i / 2);
//    }
//
//    // Solution 2


    /*


    for i => s.length()
    find the center of the longest palindrome for both odd and even cases
    save the longest length
    locate the substring by start = i - (len - 1)/2
                            end = i + len/2
                            i is the center
                            len is the length of palindrome
     */


    public String longestPalindrome_2(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    private int lo, maxLen;

    public String longestPalindrom_3(String s) {
        int len = s.length();
        if (len < 2){
            return s;
        }
        for (int i = 0; i < len - 1; i++) {
            extendPalindrom(s, i, i);
            extendPalindrom(s, i , i + 1);
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrom(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
}
