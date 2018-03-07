package DP;

/**
 * Created by JMYE on 8/27/16.
 */
public class PaintFence { // SMART
    public int numWays(int n, int k) { // O(n) O(1)
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return k;
        }
        // initial first two posts
        int diffColorCounts = k * (k - 1);
        int sameColorCounts = k * 1;
        for (int i = 2; i < n; i++) {
            int tmp = diffColorCounts;
            diffColorCounts = (diffColorCounts + sameColorCounts) * ( k - 1);
            sameColorCounts = tmp;
        }
        return diffColorCounts + sameColorCounts;
        // for the last post we still have two options for painting diff or same
        // That's way we return the sum of them

    }
}
