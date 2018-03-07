package ByComs.SumoLogic;

import java.util.Stack;

/**
 * Created by JMYE on 6/16/17.
 */

/*
Prefix Calculator
Input: Strings of math expressions
Output: Number
+ 2 3 >> 2 + 3
output = 5
+ 2 * 3 5 >> 2 + (3 * 5)
output = 17
* 3 / 2 6  >> 3 * (6/2)
output = 9
*/

public class PrefixCalculator {
    public int evalPrefixExpressioin(String[] tokens) {
        if(tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stk = new Stack<>();
        String operators = "+-*/";
        String token = null;
        for (int i = tokens.length - 1; i > -1; i--) {
            token = tokens[i];
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
        return stk.peek();

    }

    public static void main(String[] args) {
        PrefixCalculator test = new PrefixCalculator();
        String[] toks = {"+","2","3"};
        System.out.println(test.evalPrefixExpressioin(toks));
        toks = new String[]{"+", "2", "*", "3","5"};
        System.out.println(test.evalPrefixExpressioin(toks));
        toks = new String[]{"*","3","/","2","6"};
        System.out.println(test.evalPrefixExpressioin(toks));

    }
}
