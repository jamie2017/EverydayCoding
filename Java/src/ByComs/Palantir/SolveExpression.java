package ByComs.Palantir;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by JMYE on 11/4/16.
 */
public class SolveExpression {
    private static boolean dfsHelper(char[] chaArray, char[] numVisited, int pos, Map<Character, Integer> solution, Puzzle puzzle) {
        if (pos == chaArray.length) {
            if (puzzle.eval(solution, false)) {
                return true;
            }
            return false;
        }

        for (int num = 0; num <= 9; num++) {
            if (numVisited[num] > 0) {
                continue;
            }
            numVisited[num]++;
            solution.put(chaArray[pos],num);
            if (dfsHelper(chaArray, numVisited, pos + 1, solution, puzzle)) {
                return true;
            }
            numVisited[num]--;
        }
        return false;
    }

    public static Map<Character, Integer> solve(Puzzle puzzle) {
        Set<Character> chars = puzzle.getChars();
        char[] chaArray = new char[chars.size()];
        int pos = 0;
        for (char cha: chars) {
            chaArray[pos++] = cha;
        }
        char[] numVisited = new char[10];
        Map<Character, Integer> solution = new HashMap<>();
        if (dfsHelper(chaArray, numVisited, 0, solution, puzzle)) {
            puzzle.eval(solution, true);
            System.out.println(solution);
            return solution;
        }
        return null;
    }


    public static void main(String[] args) {
        Puzzle puzzle = new GetPuzzle("ONE","ONE","TWO");
        solve(puzzle);
    }
}
