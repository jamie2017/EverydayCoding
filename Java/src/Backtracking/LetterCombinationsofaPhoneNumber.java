package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by JMYE on 9/15/16.
 */
public class LetterCombinationsofaPhoneNumber {
    private static final String[] KEYS = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations_dfs(String digits) {
        List<String> rst = new ArrayList<>();
        if(digits == null || digits.length() == 0) return rst;
        combination("", digits,0, rst);
        return rst;
    }

    private void combination(String prefix, String digits, int offset, List<String> rst) {
        if (offset == digits.length()) {
            rst.add(prefix);
            return;
        }

        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length();i++) {
            combination(prefix + letters.charAt(i),digits,offset + 1, rst);
        }
    }

    public List<String> letterCombinations_bfs(String digits) {
        List<String> rst = new LinkedList<>();
        if(digits == null || digits.length() == 0) return rst;
        rst.add("");
        for (int i = 0; i < digits.length(); i++) {
            String letters = KEYS[(digits.charAt(i) - '0')];
            while(rst.get(0).length() == i) {
                String t = rst.remove(0);
                for (char s: letters.toCharArray()) {
                    rst.add(t + s);
                }
            }
        }
        return rst;
    }
}



/*


 def letterCombinations(self, digits):
        if '' == digits: return []
        kvmaps = {
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz'
        }
        return reduce(lambda acc, digit: [x + y for x in acc for y in kvmaps[digit]], digits, [''])
 */