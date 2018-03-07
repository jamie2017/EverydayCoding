package ByComs.Google;

/**
 * Created by JMYE on 6/30/17.
 */
public class AddBoldTag {
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for (int start = 0, end = 0; start < s.length(); start++) {
            for (String word : dict) {
                if (s.startsWith(word, start)) {
                    end = Math.max(end, start + word.length());
                }
            }
            bold[start] = end > start;
        }

        StringBuilder boldSb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!bold[i]) {
                boldSb.append(s.charAt(i));
                continue;
            }
            int j = i;
            while (j < s.length() && bold[j]) {
                j++;
            }
            boldSb.append("<b>" + s.substring(i, j) + "</b>");
            i = j - 1;
        }
        return boldSb.toString();
    }
}
