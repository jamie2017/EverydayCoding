package String;

/**
 * Created by JMYE on 9/23/16.
 */
public class ShortestPalindrome {

    /*

    The idea is to use two anchors j and i to compare the String from beginning and end.
    If j can reach the end, the String itself is Palindrome.
    Otherwise, we divide the String by j , and get mid = s.substring(0, j) and suffix .
    We reverse suffix as beginning of result and
    recursively call shortestPalindrome to get result of mid then appedn suffix to get result.
     */

    public String shortestPalindrome(String s) {
        // s = "aacecaaa"
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) {
                j += 1;
            }
        }
        System.out.println(j);
        // j = 7 !!! MARK here, when i,j meet, i keep loop until 0
        if (j == s.length()) {
            return s;
        }
        String suffix = s.substring(j); // suffix = "a"
        System.out.println("@ "+suffix);                                   //"aacecaa"
        String procesRst = new StringBuilder(suffix).reverse().toString() + shortestPalindrome(s.substring(0,j)) + suffix;
        System.out.println(procesRst);
        return procesRst;
    }

    public static void main(String[] argu) {
        String s = "aacecaaa";
        ShortestPalindrome test = new ShortestPalindrome();
        System.out.println(test.shortestPalindrome(s));

    }

}
