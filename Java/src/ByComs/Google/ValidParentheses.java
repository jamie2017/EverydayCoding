package ByComs.Google;

import java.util.Stack;

/**
 * Created by jianmei on 7/2/16.
 */
public class ValidParentheses {
	public boolean isValidParentheses(String s) {
		Stack<Character> stk = new Stack<>();
		int idx = 0;
		String opens = "([{";
		while(idx < s.length()) {
			char c = s.charAt(idx);
			if (opens.indexOf(c) != -1) {
				stk.push(c);
			} else {
				if (stk.isEmpty()||!match(stk.pop(),c)) {
					return false;
				}
			}
			idx ++;
		}
		return stk.isEmpty();
	}

	private boolean match(char open, char end) {
		String opens = "([{";
		String ends = ")]}";
		return opens.indexOf(open) == ends.indexOf(end);
	}
}
