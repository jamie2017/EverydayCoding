package String;

/**
 * Created by JMYE on 9/5/16.
 */
public class StringtoInteger {
    public int myAtoi(String str) {
        int index = 0, sign = 1, total = 0;
        // 1. Empty String
        if (str.length() == 0) return 0;

        // 2. Remove Spaces
        while (str.charAt(index) == ' ' && index < str.length()) {
            index ++;
        }

        // 3. Handle signs
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1: -1;
            index ++;
        }

        // 4. Convert number and avoid overflow
        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9) break;

            if (Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE % 10 < digit)
                return sign == 1 ? Integer.MAX_VALUE: Integer.MIN_VALUE;
            total = 10 * total + digit;
            index++;
        }
        return total * sign;
    }
    public static void main(String[] args) {
        String s = "--1";
        StringtoInteger test = new StringtoInteger();
        System.out.println(test.myAtoi(s));
    }
}
