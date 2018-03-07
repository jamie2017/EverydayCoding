package String;

/**
 * Created by JMYE on 11/12/16.
 */
public class RepeatedSubstringPattern {
    public static boolean repeatedSubstringPattern(String str) {
        for(int i=1; i<=str.length()/2; i++) {
            if(patternWithLength(str, i))
                return true;
        }

        return false;
    }

    private static boolean patternWithLength(String str, int len) {
        if(str.length()%len != 0)
            return false;

        for(int i=len; i<str.length(); i++) {
            if(str.charAt(i%len) != str.charAt(i))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String  str = "abcabcabc";// assume the input order has pattern
        System.out.println(repeatedSubstringPattern(str));
    }
}
