package Greedy;

/**
 * Created by JMYE on 9/24/16.
 */
public class RemoveKDigits { // MARK
    // Similar to "Largest Rectangle in Histogram"
    public String removeKdigits(String num, int k) {
        int remainLen = num.length() - k;
        char[] stk = new char[num.length()];
        int top = 0;
        // k keeps track of how many characters we can remove
        // if the previous character in stk is larger than the current one
        // then removing it will get a smaller number
        // but we can only do so when k is larger than 0
        for (int i = 0; i < num.length(); ++i) {
            char c = num.charAt(i);
            while (top > 0 && stk[top-1] > c && k > 0) {
                top --;
                k --;
            }
            stk[top++] = c;
        }
        // find the index of first non-zero digit
        int zeroIdx = 0;
        while (zeroIdx < remainLen && stk[zeroIdx] == '0') zeroIdx++;
        return zeroIdx == remainLen? "0": new String(stk, zeroIdx, remainLen - zeroIdx);
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        RemoveKDigits test = new RemoveKDigits();
        System.out.println(test.removeKdigits(num,k));
    }
}
