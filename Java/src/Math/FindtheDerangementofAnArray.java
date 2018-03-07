package Math;

/**
 * Created by JMYE on 7/2/17.
 * 634. Find the Derangement of An Array
 * https://en.wikipedia.org/wiki/Derangement#Counting_derangements
 */
public class FindtheDerangementofAnArray {
    private static final int M = 1000000007;
    public int findDerangement(int n) {
        long ans = 1;
        for (int i = 1; i <= n; i++)
            ans = (i * ans % M + (i % 2 == 0 ? 1 : -1)) % M;
        return (int) ans;
    }
}
