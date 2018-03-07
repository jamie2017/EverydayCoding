package Stack;

import java.util.Stack;

/**
 * Created by JMYE on 11/24/16.
 */
public class TernaryExpressionParser {
    /*
    Input: "F?1:T?4:5"

    Output: "4"
     */

    // stack
    public String parseTernary(String expression) {
        if (expression == null || expression.length() == 0) return "";
        Stack<Character> stack = new Stack<>();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '?') {

                stack.pop(); //pop '?'
                char first = stack.pop();
                stack.pop(); //pop ':'
                char second = stack.pop();

                if (c == 'T') stack.push(first);
                else stack.push(second);
            } else {
                stack.push(c);
            }
        }

        return String.valueOf(stack.peek());

    }



    // Another solution: very smart !!
    // In order to pick out useful "?" and ":",
    // we can always begin with the last "?" and the first ":" after the chosen "?".
    // Therefore, directly seek for the last "?"
    // (or you can simply put all "?" into a stack)
    // and update the string depending on T or F until no more "?"s.
    public String parseTernary2(String expression) {
        while (expression.length() != 1) {
            int i = expression.lastIndexOf("?");    // get the last shown '?'
            char tmp;
            if (expression.charAt(i-1) == 'T') { tmp = expression.charAt(i+1); }
            else { tmp = expression.charAt(i+3); }
            expression = expression.substring(0, i-1) + tmp + expression.substring(i+4);
        }
        return expression;
    }
}
