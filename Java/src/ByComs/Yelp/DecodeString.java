package ByComs.Yelp;

/**
 * Created by JMYE on 11/3/16.
 */
public class DecodeString {// aaabcbc -> 3a1b1c1b1c
    public static String decodeString(String str) {
        if (str == null || str.length() < 1) return "";

        StringBuilder sb = new StringBuilder();
        char prev = str.charAt(0);
        int L = 0,R = 1;
        while (R < str.length()) {
            if (prev != str.charAt(R)) {
                sb.append(R - L + "");
                sb.append(prev + "");
                L = R;
                prev = str.charAt(R);
            }
            R++;
        }
        sb.append(R - L + "");
        sb.append(prev + "");
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "aaabbbccca";
        System.out.println(decodeString(s));
    }

}
