package DP;

/**
 * Created by JMYE on 10/5/16.
 */


// Give a sequence S and T, how many distinct sub sequences from S equals to T?
//    S = "rabbbit", T = "rabbit"

//            Return 3.
public class DistinctSubsequences { // MARK
    public int numDistinct(String S, String T) {
        // array creation
        int[][] mem = new int[T.length()+1][S.length()+1];

        // filling the first row: with 1s
        for(int j = 0; j <= S.length(); j++) {
            mem[0][j] = 1;
        }

        // the first column is 0 by default in every other rows but the first, which we need.

        for(int i = 0; i < T.length(); i++) {
            for(int j = 0; j < S.length(); j++) {
                if(T.charAt(i) == S.charAt(j)) {
                    mem[i + 1][j + 1] = mem[i][j] + mem[i + 1][j];
                } else {
                    mem[i + 1][j + 1] = mem[i + 1][j];
                }
            }
        }

        return mem[T.length()][S.length()];
    }

    public int numDistinct_1arr(String S, String T) {
        int sl = S.length();
        int tl = T.length();

        int[] dp = new int[tl+1];
        dp[0] = 1;

        for(int s=1; s<=sl; s++)
            for(int t=tl; t>=1; t--){
                if(S.charAt(s-1)==T.charAt(t-1))
                    dp[t] += dp[t-1];
            }

        return dp[tl];
    }

    public static void main (String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        DistinctSubsequences test = new DistinctSubsequences();
        System.out.println(test.numDistinct(s,t));
    }
}
