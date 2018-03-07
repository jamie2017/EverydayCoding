package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 9/16/16.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> rst = new ArrayList<String>();
        backtrack(rst, "", 0, 0, n);
        return rst;
    }

    private void backtrack(List<String> rst, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            rst.add(str);
            return;
        }

        if (open < max) {
            backtrack(rst, str + '(', open + 1, close, max);
        }
        if (close < open) {
            backtrack(rst, str + ')', open, close + 1, max);
        }
    }
}
