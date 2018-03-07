package BitManipulation;

/**
 * Created by JMYE on 11/28/16.
 */
public class ConvertaNumberToHexadecimal {
    /*
Basic idea: each time we take a look at the last four digits of
            binary verion of the input, and maps that to a hex char
            shift the input to the right by 4 bits, do it again
            until input becomes 0.

*/
    public static String toHex(int num) {
        StringBuilder sb = new StringBuilder();
        do {
            int n = num & 0xf;
            n += n < 0xa ? '0' : 'a' - 10;
            sb.append((char)n);
            System.out.println((char) n );
        } while ((num >>>= 4) != 0);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        int num = 26;
//        int num = -1;
        System.out.println(toHex(num));
    }
}
