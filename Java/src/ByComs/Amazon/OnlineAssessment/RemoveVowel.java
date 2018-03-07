package ByComs.Amazon.OnlineAssessment;

/**
 * Created by JMYE on 10/9/16.
 */
public class RemoveVowel {
    public static String removeVowel(String s) {
        StringBuilder sb = new StringBuilder();
        String vowerls = "aeiouAEIOU";
        for (int i = 0; i < s.length();i++) {
            if(vowerls.indexOf(s.charAt(i)) > -1) continue;
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "abdhfgebsa";
        System.out.println(removeVowel(str));
    }
}
