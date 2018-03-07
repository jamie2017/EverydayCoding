package DFS;

import java.util.*;

/**
 * Created by JMYE on 9/22/16.
 */
public class RemoveInvalidParentheses { // MARK!!!!!!
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(',')'});
        return ans;
    }

    private void remove (String s, List<String> ans, int last_i, int last_j, char[] par) {
        for (int count = 0, i = last_i; i < s.length(); ++i) {
            if (s.charAt(i) == par[0]) count++;
            if (s.charAt(i) == par[1] ) count --;
            if (count >= 0) continue;
            for (int j = last_j; j <= i; ++j) {
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1])) {
                    remove(s.substring(0,j) + s.substring(j + 1, s.length()), ans, i, j, par);
                }
            }
            return;
        }

//         Tricky!!
//         Need to check both sides to avoid cases like "(((()"
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') { // finished left to right
            remove(reversed, ans, 0,0, new char[]{')','('});
        } else { // finished right to left
            ans.add(reversed);
        }
    }



    private static final String parentheses = "()";
    public List<String> removeInvalidParenthesesBfs(String s) {
        Set<String> visited = new HashSet<>();
        visited.add(s);
        List<String> ans = new ArrayList<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(s);
        boolean done = false;
        while (!queue.isEmpty()) {
            String curS = queue.poll();
            int mismatchCnt = countMismatch(curS);
            if (mismatchCnt == 0) {
                done = true;
                ans.add(curS);
            }
            if (done) continue;
            for (int i = 0; i < curS.length(); i++) {
                if (parentheses.indexOf(curS.charAt(i)) == -1) continue;
                String newS = curS.substring(0,i) + curS.substring(i+1);
                if (!visited.contains(newS) && countMismatch(newS) < mismatchCnt) {
                    visited.add(newS);
                    queue.offer(newS);
                }
            }
        }
        return ans;
     }

    private int countMismatch(String s) {
        int open = 0, close = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                open ++;
            } else if (c == ')') {
                open --;
            }
            if (open < 0) {
                close ++;
            }
            open = Math.max(open,0);
        }
        return open + close;
    }


    public static void main(String[] argu) {
//        String s = "()())()";
        String s = "(((((((()";
        RemoveInvalidParentheses test = new RemoveInvalidParentheses();
        System.out.println(test.removeInvalidParentheses(s));
        System.out.println(test.removeInvalidParenthesesBfs(s));
    }
}
