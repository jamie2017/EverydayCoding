package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by JMYE on 9/2/16.
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] cand, int target) {
        Arrays.sort(cand);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        dfs_com(cand, 0, target, path, res);
        return res;
    }
    private void dfs_com (int[] cand, int cur, int target, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return ;
        }
        if (target < 0) return;
        for (int i = cur; i < cand.length; i++) {
            if (i > cur && cand[i] == cand[i - 1]) continue; // result set is unique
            path.add(path.size(), cand[i]);
            dfs_com(cand, i + 1, target - cand[i], path, res);
            // list in result is also unique
            path.remove(path.size() - 1);
        }
    }

}
