package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by JMYE on 11/19/16.
 */
public class RussianDollEnvelopes {
    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        int maxCnt = 0;
        int[] dp = new int[envelopes.length];
        Arrays.sort(envelopes, (a, b)->a[0] == b[0]? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < envelopes.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxCnt = Math.max(maxCnt, dp[i]);
        }
        return maxCnt;
    }

    public static int maxEnvelopesBS(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b)->a[0] == b[0]? b[1] - a[1] : a[0] - b[0]);// !!!!
        List<int[]> tails = new ArrayList<>();
        for (int i = 0; i < envelopes.length;i++) {
            int[] e = envelopes[i];
            int pos = binarySearch(tails,e[1]);
            if (pos == tails.size()) {
                tails.add(e);
            } else {
                tails.set(pos, e);
            }
        }
        return tails.size();

    }
    private static int binarySearch(List<int[]> tails, int val) {
        int left = 0, right = tails.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (tails.get(mid)[1] < val) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        System.out.println(maxEnvelopesBS(envelopes));
        System.out.println(maxEnvelopes(envelopes));
    }
}
