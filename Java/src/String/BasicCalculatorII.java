package String;

import java.util.Stack;

/**
 * Created by JMYE on 9/19/16.
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        if(s.length() == 0)
            return 0;
        char operator = '+';
        char partOperator = '*';
        int sum = 0;
        int partVal = 1;
        int curVal = 0;

        for(int i=0; i<=s.length(); i++) {
            char c = i==s.length() ? 0 : s.charAt(i);
            if(c == ' ')
                continue;
            if(c >='0' && c <='9') {
                curVal = curVal * 10 + (c - '0');
                continue;
            }
            if(c == 0 || "+-*/".indexOf(c) >= 0) {
                partVal = partOperator == '*' ? partVal * curVal : partVal / curVal;
                curVal = 0;
                if(c == '+' || c == '-' || c == 0) {
                    sum += operator == '+' ? partVal : -partVal;
                    partVal = 1;
                    operator = c;
                    partOperator = '*';
                } else {
                    partOperator = c;
                }
            }
        }
        return sum;
    }


    public int calculatorII(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String newS = s.replace(" ","");
        Stack<Long> stk = new Stack<>();
        long num = 0;
        int sign = '+';
        for (int i = 0; i < newS.length(); i++) {
            char c = newS.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (!Character.isDigit(c) || i == newS.length() - 1) {
                switch (sign) {
                    case '+':
                        stk.push(1 * num);
                        break;
                    case '-':
                        stk.push(-1 * num);
                        break;
                    case '*':
                        stk.push(stk.pop() * num);
                        break;
                    case '/':
                        stk.push(stk.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }
        int ans = 0;
        while (!stk.isEmpty())
        {
            ans += stk.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        BasicCalculatorII test = new BasicCalculatorII();
        System.out.println(test.calculatorII("3+2*2")); // 7
    }
}
