package Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 11/17/16.
 */
public class LexicalOrder {
    /*
    The basic idea is to find the next number to add.
Take 45 for example: if the current number is 45, the next one will be 450 (450 == 45 * 10)(if 450 <= n),
 or 46 (46 == 45 + 1) (if 46 <= n) or 5 (5 == 45 / 10 + 1)(5 is less than 45 so it is for sure less than n).
We should also consider n = 600, and the current number = 499, the next number is 5 because there are all "9"s after "4" in "499" so we should divide 499 by 10 until the last digit is not "9".
It is like a tree, and we are easy to get a sibling, a left most child and the parent of any node.
     */

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>(n);
        for (int i = 1, curr = 1; i <= n; ++i) {
            ans.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else {
                while (curr % 10 == 9 || curr == n) curr /= 10;
                curr++;
            }

        }
        return ans;
    }

    public static int findKthNumberInLexicalOrder(int n, int k) {
        for (long i = 1, curr = 1; i <= n; ++i) {
            if (i == k) return (int)curr;
            if (curr * 10 <= n) {
                curr *= 10;
            } else {
                while (curr % 10 == 9 || curr == n) curr /= 10;
                curr++;
            }

        }
        return -1;
    }

    public static int findKthNumber(int n, int k) { // better solution, avoid unnecessary steps
        // https://discuss.leetcode.com/topic/64624/concise-easy-to-understand-java-5ms-solution-with-explaination/2
        int curr = 1;
        k = k - 1;
        while (k > 0) {
            int steps = calSteps(n, curr, curr + 1);
            if (steps <= k) {
                curr += 1;
                k -= steps;
            } else {
                curr *= 10;
                k -= 1;
            }
        }
        return curr;
    }
    //use long in case of overflow
    public static int calSteps(int n, long n1, long n2) {
        int steps = 0;
        while (n1 <= n) {
            steps += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return steps;
    }

    public static void main(String[] args) {
        int n = 957747794;
        int k = 424238336;
        System.out.println(findKthNumberInLexicalOrder(n,k));

    }
}
