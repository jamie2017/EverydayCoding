package Stack;

import java.util.Stack;

/**
 * Created by JMYE on 9/21/16.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<Integer>();
        String operators = "+-*/";
        for (String token : tokens) {
            if (!operators.contains(token)) {
                stk.push(Integer.valueOf(token));
                continue;
            }

            int a = stk.pop();
            int b = stk.pop();
            if (token.equals("+")) {
                stk.push(a + b);
            } else if (token.equals("-")) {
                stk.push(b - a);
            } else if (token.equals("*")) {
                stk.push(a * b);
            } else {
                stk.push(b / a);
            }
        }
        return stk.isEmpty()? 0 :stk.pop();
    }
}
