package TwoPointer;

/**
 * Created by JMYE on 11/5/16.
 */
public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int[] count = new int[128];
        int maxCount = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end ++) {
            count[s.charAt(end)]++;
            maxCount = Math.max(maxCount, count[s.charAt(end)]);
            if (maxCount + k <= end - start) {
                count[s.charAt(start)]--;
                start++;
            }
        }
        System.out.println(maxCount);
        System.out.println(start);
        return s.length() - start;
    }

    public static void main(String[] args) {
        String s = "AAABBAA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }
}
