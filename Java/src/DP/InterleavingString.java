package DP;

/**
 * Created by JMYE on 9/19/16.
 */
public class InterleavingString {


    public boolean isInterleave_2d(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean [][] interleaved = new boolean[s1.length() + 1][s2.length() + 1];
        interleaved[0][0] = true;

        for (int i = 1; i <= s1.length(); i++) {
            if(s3.charAt(i - 1) == s1.charAt(i - 1) && interleaved[i - 1][0])
                interleaved[i][0] = true;
        }

        for (int j = 1; j <= s2.length(); j++) {
            if(s3.charAt(j - 1) == s2.charAt(j - 1) && interleaved[0][j - 1])
                interleaved[0][j] = true;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if(((s3.charAt(i + j - 1) == s1.charAt(i - 1) && interleaved[i - 1][j]))
                        || ((s3.charAt(i + j - 1)) == s2.charAt(j - 1) && interleaved[i][j - 1]))
                    interleaved[i][j] = true;
            }
        }

        return interleaved[s1.length()][s2.length()];
    }

    public static boolean isInterleaveOptz(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;

        boolean[] optimal = new boolean[s2.length() + 1];    //dp optimal
        optimal[0] = true;
        for (int j = 0; j < s2.length(); j++) { //check no s1 char is selected, if s2 could equals to s3
            if (optimal[j] && s2.charAt(j) == s3.charAt(j)) optimal[j + 1] = true;
        }

        for (int i = 0; i < s1.length(); i++) { //check select i-th char in s1
            if (optimal[0] && s1.charAt(i) == s3.charAt(i)) optimal[0] = true;    //no char in s2 is selected
            else optimal[0] = false;
            for (int j = 0; j < s2.length(); j++) {  //select j-th char
                if ((s1.charAt(i) == s3.charAt(i + j + 1) && optimal[j + 1]) ||
                        s2.charAt(j) == s3.charAt(i + j + 1) && optimal[j]) {
                    optimal[j + 1] = true;
                } else optimal[j + 1] = false;
            }
        }
        return optimal[s2.length()];
    }

}
