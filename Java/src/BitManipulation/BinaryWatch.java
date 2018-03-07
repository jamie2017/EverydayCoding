package BitManipulation;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by JMYE on 9/22/16.
 */
public class BinaryWatch { // MARK!
    public List<String> readBinaryWatch(int num) {
        List<String> ans = new LinkedList<>();
        dfs(ans, num, 0, new int[2]);
        return ans;
    }
    void dfs(List<String> ans, int k, int i, int[] hhmm) {
        if (i == 10 || k <= 0) {
            if (k == 0 && hhmm[0] < 12 && hhmm[1] < 60)
                ans.add(String.format("%d:%02d", hhmm[0], hhmm[1]));
            return;
        }
        int idx = i < 4 ? 0 : 1;
        int val = 1 << (i < 4 ? i : i - 4);
        hhmm[idx] += val;
        dfs(ans, k - 1, i + 1, hhmm);
        hhmm[idx] -= val;
        dfs(ans, k, i + 1, hhmm);
    }
}
