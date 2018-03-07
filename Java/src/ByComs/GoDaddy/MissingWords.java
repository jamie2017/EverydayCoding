package ByComs.GoDaddy;

import java.util.ArrayList;
import java.util.List;

/**
     * Created by JMYE on 9/29/16.
     */
public class MissingWords {
    public List<String> missingWors(String s, String t) {
            List<String> rst = new ArrayList<>();
            if (s == null && t != null) {
                return rst;
            }
            if (s != null && t == null) {
                rst.add(s);
                return rst;
            }
            if (s.length() < t.length()) {
                return rst;
            }

            int j = 0;
            for (int i = 0; i < s.length();i++) {
                if (j < t.length() && s.charAt(i) == t.charAt(j) ) {
                    j++;
                } else {
                    rst.add(""+s.charAt(i));
                }
            }
            return rst;
    }

    public static void main(String[] args) {
        MissingWords test = new MissingWords();
        String s = "I love cici very much!";
        String t = "cici";
        System.out.println(test.missingWors(s,t));
    }


}
