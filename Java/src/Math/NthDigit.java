package Math;

/**
 * Created by JMYE on 9/30/16.
 */
public class NthDigit { // MARK
    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        String s = Integer.toString(start);
        System.out.println(s);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }

    public static void main(String[] args) {
        int n = 1901;
        NthDigit test = new NthDigit();
        System.out.println(test.findNthDigit(n));
    }
}
