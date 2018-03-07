package Stack;

import java.util.Stack;

/**
 * Created by JMYE on 9/22/16.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        int maxLen = 0;
        int validLeft = -1;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stk.push(i);
            } else {
                if (stk.isEmpty()) {
                    validLeft = i;// )()())()()()
                } else {
                    stk.pop();
                    if (stk.isEmpty()) maxLen = Math.max(maxLen, i - validLeft);//()()()
                    else {
                        maxLen = Math.max(maxLen, i - stk.peek()); // (()()
                    }
                }

            }
        }
        return maxLen;
    }

    // dp
    public int longestValidParentheses_dp(String s) {
        if (s.length() == 0)
            return 0;
        int maxLen = 0;
        int[] d = new int[s.length()];
        // d[i] means substring starts with i has max valid length of d[i]
        d[s.length() - 1] = 0;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == ')')
                d[i] = 0;
            else {
                int j = (i + 1) + d[i + 1];
                if (j < s.length() && s.charAt(j) == ')') {
                    d[i] = d[i + 1] + 2; //(()())的外包情况
                    if (j + 1 < s.length())
                        d[i] += d[j + 1];//()()的后面还有的情况
                }
            }
            maxLen = Math.max(maxLen, d[i]);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestValidParentheses test = new LongestValidParentheses();
        String s = ")()())";
        System.out.println(test.longestValidParentheses(s));
        System.out.println(test.longestValidParentheses_dp(s));
    }
}

