package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 11/25/16.
 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(rst, sb, num.toCharArray(), 0, target, 0, 0);
        return rst;
    }

    private void helper(List<String> rst, StringBuilder sb, char[] num, int pos, int target, long prev, long multi) {
        if(pos == num.length) {
            if(target == prev)  {
                rst.add(sb.toString());
            }
            return;
        }
        long curr = 0;
        for (int i = pos; i < num.length; i++) {
            if(num[pos] == '0' && i != pos) return;
            curr = 10 * curr + num[i] - '0';
            int len = sb.length();
            if (pos == 0) {
                helper(rst, sb.append(curr), num, i + 1, target, curr, curr);
                sb.setLength(len);
            } else {
                helper(rst, sb.append("+").append(curr), num, i + 1, target, prev + curr, curr);
                sb.setLength(len);
                helper(rst, sb.append("-").append(curr), num, i + 1, target, prev - curr, -curr);
                sb.setLength(len);
                helper(rst, sb.append("*").append(curr), num, i + 1, target, prev - multi + multi * curr, multi * curr);
                /*
                prev - multi + multi * curr

                for example, if you have a sequence of 12345 and you have proceeded to 1 + 2 + 3,
                now your eval is 6 right? If you want to add a * between 3 and 4, you would take 3 as the digit to be multiplied,
                so you want to take it out from the existing eval.
                You have 1 + 2 + 3 * 4 and the eval now is (1 + 2 + 3) - 3 + (3 * 4)
                 */
                sb.setLength(len);
            }
        }
    }

    public static void main(String[] args) {
        ExpressionAddOperators test = new ExpressionAddOperators();
        String[] s = {"101","1231","232","105","000","3456237490"};
        int[] targets ={1,123,8,5,0,9191};
        for (int i = 0; i < s.length; i++) {
            System.out.println(test.addOperators(s[i], targets[i]));
        }

//        StringBuilder sb = new StringBuilder();
//        System.out.println(sb.append(100).append("200"));
    }
}
