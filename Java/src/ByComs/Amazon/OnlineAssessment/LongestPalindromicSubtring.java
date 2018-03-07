package ByComs.Amazon.OnlineAssessment;

/**
 * Created by JMYE on 10/11/16.
 */
public class LongestPalindromicSubtring {
    public String longestPalindrome(String s) {
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
        return R - L - 1;// -1 because after while L and R are already out of bound
    }

    // solution 2
    private static String findSub(String str) {

        int length = str.length();
        boolean table[][] = new boolean[length][length];

        int start = 0, end = 0,longest = 0;

        table[0][0] = true;
        for(int i=1; i < length; i++)
        {
            table[i][i] = true;
            table[i][i-1] = true;//abba这样的substring需要
        }

        for(int k = 2; k <= length; k++)//substring length
        {
            for(int i = 0; i <= length-k; i++)
            {
                int j = i+k-1;

                if(str.charAt(i) == str.charAt(j) && table[i+1][j-1] == true)
                {
                    table[i][j] = true;
                    if(longest < k)
                    {
                        longest = k;
                        start = i;
                        end = j+1;
                    }
                }
            }
        }

        str = str.substring(start,end);
        return str;
    }

    // solution 3
    public String longestPalindrome_3(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int length = s.length();
        int max = 0;
        String result = "";
        for(int i = 1; i <= 2 * length - 1; i++){
            int count = 1;
            while(i - count >= 0 && i + count <= 2 * length  && get(s, i - count) == get(s, i + count)){
                count++;
            }
            count--; // there will be one extra count for the outbound #
            if(count > max) {
                result = s.substring((i - count) / 2, (i + count) / 2);
                max = count;
            }
        }

        return result;
    }

    private char get(String s, int i) {
        if(i % 2 == 0)
            return '#';
        else
            return s.charAt(i / 2);
    }
//

    public static void main (String[] args) {
        String s = "abba";
        LongestPalindromicSubtring test = new LongestPalindromicSubtring();
        System.out.println(test.longestPalindrome(s));
//        System.out.println(test.findSub(s));
//        System.out.println(test.longestPalindrome_3(s));

    }
}
