package BitManipulation;

/**
 * Created by JMYE on 8/28/16.
 */
// 389. Find the Difference , only one char different
public class FindDifference {
    public char findTheDifference(String s, String t) {
        char c = 0;
        for (int i = 0; i < s.length(); i++) {
            c ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            c ^= t.charAt(i);
        }
        return c;
    }

    public static void main(String[] args) {
        FindDifference test = new FindDifference();
        String s = "abccddee";
        String t = "abcctddee";
        System.out.println(test.findTheDifference(s,t));
    }
}
