package DP;

/**
 * Created by JMYE on 9/17/16.
 */
public class EditDistance {
    /*

    f(i, j) := minimum cost (or steps) required to convert first i characters of word1 to first j characters of word2
w1(0:i)
w2(0:j)

Case 1: word1[i] == word2[j], i.e. the ith the jth character matches.

f(i, j) = f(i - 1, j - 1)
Case 2: word1[i] != word2[j], then we must either insert, delete or replace, whichever is cheaper

f(i, j) = 1 + min { f(i, j - 1), f(i - 1, j), f(i - 1, j - 1) }
f(i, j - 1) represents insert operation
f(i - 1, j) represents delete operation
f(i - 1, j - 1) represents replace operation

     */

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] cost = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            cost[i][0] = i;
        }
        for(int i = 1; i <= n; i++) {
            cost[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    cost[i][j] = cost[i - 1][j - 1];
                } else {
                    int replace = cost[i - 1][j - 1];
                    int insert = cost[i][j - 1]; // add j
                    int delete = cost[i - 1][j]; // delete
                    cost[i][j] = Math.min(replace,Math.min(insert,delete)) + 1;
                }
            }
        }
        return cost[m][n];
    }

    // recursive
    public int minDistance_rec(String word1, String word2) {
        char[] w1 = word1.toCharArray(), w2 = word2.toCharArray();
        int[][] memo = new int[w1.length+1][w2.length+1];
        return minDistanceHelper(w1, w2, 0, 0, memo);
    }

    public int minDistanceHelper(char[] w1, char[] w2, int w1Index, int w2Index, int[][] memo) {
        if(w1Index == w1.length) return w2.length - w2Index;
        if(w2Index == w2.length) return w1.length - w1Index;

        if(memo[w1Index][w2Index] != 0) return memo[w1Index][w2Index];

        if(w1[w1Index] == w2[w2Index]) {
            memo[w1Index][w2Index] = minDistanceHelper(w1, w2, w1Index+1, w2Index+1, memo);
        } else {
            int opt1 = minDistanceHelper(w1, w2, w1Index+1, w2Index, memo);
            int opt2 = minDistanceHelper(w1, w2, w1Index, w2Index+1, memo);
            int opt3 = minDistanceHelper(w1, w2, w1Index+1, w2Index+1, memo);
            memo[w1Index][w2Index] = Math.min(opt1, Math.min(opt2, opt3)) + 1;
        }
        return memo[w1Index][w2Index];
    }

}
