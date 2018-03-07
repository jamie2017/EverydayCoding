package ByComs.Yelp;

/**
 * Created by JMYE on 11/7/16.
 */
public class Compress {
    public static String com(String str) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            cnt++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                sb.append(cnt).append(str.charAt(i));
                cnt = 0;
            }
        }
        return sb.toString();
    }

    //把所有连续出现两次或以上的字符缩减到一个
    public static String com2(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "aaabbbccca";
        System.out.println(com(s));
        String s2 = "aaabbbccdccc";
        System.out.println(com2(s2));
    }
}
