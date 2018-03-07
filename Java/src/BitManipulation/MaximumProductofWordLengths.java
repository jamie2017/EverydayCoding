package BitManipulation;

/**
 * Created by JMYE on 9/20/16.
 */
public class MaximumProductofWordLengths {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        int [] bitValue = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String tmp = words[i];
            bitValue[i] = 0;
            // !!!! 1 << 3 means 1 move to left 3 bits from right, pass three zero
            // from 001 becomes 1000
            // abcd:
            // a - 'a' = 0, so 1 << 0 : 001 no change
            // b - 'a' = 1, so 1 << 1 : 010 pass one zero
            // c - 'a' = 2, so 1 << 2 : 100 pass two zero
            // d - 'a' = 3, so 1 << 3 :1000 pass three zero
            // | them up >>            1111
            // if no same characters between two words,
            // then "abcd" & "eg" == 0, which is the condition we need
            for (int j = 0; j < tmp.length();j++) {
                bitValue[i] |= 1 << (tmp.charAt(j) - 'a');
            }
        }

        int rst = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bitValue[i] & bitValue[j]) == 0) {
                    rst = Math.max(rst, words[i].length() * words[j].length());

                }
            }
        }
        return rst;
    }
}
