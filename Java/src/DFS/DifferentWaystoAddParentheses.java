package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JMYE on 9/22/16.
 */
public class DifferentWaystoAddParentheses { // MARK
    public List<Integer> diffWaysToCompute(String input) {
        return diffWaysToCompute(input, new HashMap<String, List<Integer>>());
    }

    private List<Integer> diffWaysToCompute (String input, Map<String, List<Integer>> map) {
        if (map.containsKey(input)) {
            return map.get(input);
        }
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char curChar = input.charAt(i);
            if (curChar == '+' || curChar == '-' || curChar == '*') {
                String leftPart = input.substring(0,i);
                String rightPart = input.substring(i + 1);
                List<Integer> leftRst = diffWaysToCompute(leftPart, map);
                List<Integer> rightRst = diffWaysToCompute(rightPart,map);
                for (Integer left : leftRst) {
                    for (Integer right : rightRst) {
                        int curRst = 0;
                        switch ( (curChar)) {
                            case '+':
                                curRst = left + right;
                                break;
                            case '-':
                                curRst = left - right;
                                break;
                            case '*':
                                curRst = left * right;
                                break;
                        }
                        ways.add(curRst);
                    }
                }
            }
        }
        if (ways.size() == 0) {
            ways.add(Integer.parseInt(input));
        }

        map.put(input,ways);
        return ways;
    }

    public static void main(String[] args) {
        DifferentWaystoAddParentheses test = new DifferentWaystoAddParentheses();
        System.out.println(test.diffWaysToCompute("2-1-1"));
    }
}
