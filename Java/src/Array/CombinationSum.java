package Array;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by JMYE on 9/12/16.
 */
public class CombinationSum {//O(N*2^N)vvvvvvv
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getResult(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void getResult(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start ) {
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
            cur.add(candidates[i]);
            getResult(result, cur, candidates,target - candidates[i],i);
            cur.remove(cur.size() - 1);
        }
    }

    public List<List<Integer>> combinationSumDP(int[] candidates, int target) {
        Arrays.sort(candidates); // sort candidates to try them in asc order
        List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 1; i <= target; i++) { // run through all targets from 1 to t
            List<List<Integer>> newList = new ArrayList(); // combs for curr i
            // run through all candidates <= i
            for (int j = 0; j < candidates.length && candidates[j] <= i; j++) {
                // special case when curr target is equal to curr candidate
                if (i == candidates[j]) newList.add(Arrays.asList(candidates[j]));
                    // if current candidate is less than the target use prev results
                else for (List<Integer> l : dp.get(i - candidates[j] - 1)) {
                    if (candidates[j] <= l.get(0)) {
                        List cl = new ArrayList<>();
                        cl.add(candidates[j]);
                        cl.addAll(l);
                        newList.add(cl);
                    }
                }
            }
            dp.add(newList);
        }
        return dp.get(target - 1);
    }

}
