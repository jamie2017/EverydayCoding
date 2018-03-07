package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 9/12/16.
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> rst = new ArrayList<>();
        combination(rst, new ArrayList<Integer>(),k, 1, n);
        return rst;
    }

    private void combination(List<List<Integer>> rst, List<Integer> comb, int k, int start, int n) {
        if (comb.size() == k && n == 0) {
            List<Integer> sub = new ArrayList<>(comb);
            rst.add(sub);
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            combination(rst,comb,k,i + 1,n - i);
            comb.remove(comb.size() - 1);
        }
    }
}
