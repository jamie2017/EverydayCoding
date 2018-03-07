package ByComs.Yelp;

/**
 * Created by JMYE on 11/7/16.
 */
public class rmE {
    public static String rm (String s) {
        StringBuilder sb = new StringBuilder();
        boolean eBefore = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'e') {
                if (eBefore)
                    continue;
                else {
                    eBefore = true;
                    sb.append(s.charAt(i));
                }
            }
            else {
                eBefore = false;
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "adheesheeee";
        System.out.println(rm(s));
    }
}
