package ByComs.Palantir;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by JMYE on 11/3/16.
 */
interface Puzzle {
    Set<Character> getChars();
    boolean eval(Map<Character, Integer> proposedSolution, boolean print);
}
public class GetPuzzle  implements Puzzle {
    String input1, input2, result;
    Set<Character> chars;

    public GetPuzzle(String s1, String s2, String rst) {
        input1 = s1;
        input2 = s2;
        result = rst;
        chars = new HashSet<>();
    }

    private void addChar(Set<Character> chars, String s) {
        for (int pos = 0; pos < s.length(); pos++) {
            chars.add(s.charAt(pos));
        }
    }

    public Set<Character> getChars() {
        addChar(chars, input1);
        addChar(chars, input2);
        addChar(chars, result);
        return chars;
    }

    private int getNum(String s, Map<Character, Integer> proposedSolution) {
        int rst = 0;
        for (int pos = 0; pos < s.length(); pos++) {
            if (pos == 0 && proposedSolution.get(s.charAt(pos)) == 0) break;
            rst = rst * 10 + proposedSolution.get(s.charAt(pos));
        }
        return rst;
    }

    public boolean eval(Map<Character, Integer> proposedSolution, boolean print) {
        int num1 = getNum(input1, proposedSolution), num2 = getNum(input2, proposedSolution);
        int rst = getNum(result, proposedSolution);
        if (print) {
            System.out.println(rst + " = " + num1 + " + " + num2);
        }
        return rst == (num1 + num2);
    }

}







