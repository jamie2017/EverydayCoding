package Array;

import java.util.List;

/**
 * Created by JMYE on 6/19/17.
 */
public class MaximumDistanceInArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        int maxDist = Integer.MIN_VALUE;
        int maxR = arrays.get(0).get(arrays.get(0).size() - 1);
        int minL = arrays.get(0).get(0);

        for (int i = 1; i < arrays.size();i++) {
            maxDist = Math.max(maxDist, Math.abs(maxR - arrays.get(i).get(0)));
            maxDist = Math.max(maxDist, Math.abs(minL - arrays.get(i).get(arrays.get(i).size() - 1)));
            maxR = Math.max(maxR, arrays.get(i).get(arrays.get(i).size() - 1));
            minL = Math.min(minL, arrays.get(i).get(0));
        }
        return maxDist;
    }
}
