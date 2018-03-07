package ByComs.Amazon.OnlineAssessment;

import java.util.Stack;

/**
 * Created by JMYE on 10/9/16.
 */
public class ValidParentheses {
    public boolean isValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case '(':
                    stack.push('(');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case '{':
                    stack.push('{');
                    break;
                case ')':
                    if (stack.size() == 0 || stack.pop() != '(') return false;
                    break;
                case ']':
                    if (stack.size() == 0 || stack.pop() != '[') return false;
                    break;
                case '}':
                    if (stack.size() == 0 || stack.pop() != '{') return false;
                break;
            }
        }

        return stack.isEmpty();
    }

    // follow up  improved by using char
    public boolean isValid_char(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) - stack.peek() == 1 || s.charAt(i) - stack.peek() == 2) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public static void main (String[] args) {

        String s = "()";
        ValidParentheses test = new ValidParentheses();
        System.out.println(test.isValidParentheses(s));
    }
}
