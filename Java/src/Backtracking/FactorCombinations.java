package Backtracking;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 9/15/16.
 */
public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        helper(rst, new ArrayList<>(), n , 2);// should be >1 and <n ,so start with 2
        return rst;
    }

    private void helper(List<List<Integer>> rst, List<Integer> factor, int n, int start) {
        if (n <= 1) {
            if (factor.size() > 1) {
                rst.add(new ArrayList<>(factor));
            }
            return;
        }

        for (int i = start; i <= n; ++i) {
            if (n % i == 0) {
                factor.add(i);
                helper(rst,factor,n / i,i);
                factor.remove(factor.size() - 1);
            }
        }
    }
}

