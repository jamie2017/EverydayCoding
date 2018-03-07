package String;

/**
 * Created by JMYE on 9/19/16.
 */
public class MultiplyString {
    //https://discuss.leetcode.com/topic/30508/easiest-java-solution-with-graph-explanation

    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int prod = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = prod + pos[p2];
// `num1[i] * num2[j]` will be placed at indices `[i + j`, `i + j + 1]`
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}


