package DP;

import java.util.Arrays;

/**
 * Created by JMYE on 5/10/17.
 */
public class MaximumVacations {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int NINF = Integer.MIN_VALUE;
        int N = days.length, K = days[0].length;
        int[] best = new int[N];
        Arrays.fill(best, NINF);
        best[0] = 0;
        for (int t = 0; t < K; t++) {
            int[] tmp = new int[N];
            Arrays.fill(tmp,NINF);
            for(int i = 0; i < N; i++) {
                for (int j = 0; j < flights[i].length; j++) {
                    if (flights[i][j] != 0 || i == j) {
                        tmp[j] = Math.max(tmp[j], best[i] + days[j][t]);
                    }
                }
            }
            best = tmp;
        }
        int maxVals = 0;
        for(int b:best) {
            maxVals = Math.max(maxVals, b);
        }
        return maxVals;
    }
}
