package BinaryIndexedTree_SegmentTree;

import java.util.*;

/**
 * Created by JMYE on 11/17/16.
 */
public class GetSkyline {
    public List<int[]> getSkyline(int[][] buildings) { // O(nlogn)
        List<int[]> heights = new ArrayList<>();
        for (int[] b: buildings) {
            heights.add(new int[]{b[0], -b[2]}); // negative stands for start
            heights.add(new int[]{b[1], b[2]});  // postive stands for end
        }
        Collections.sort(heights, (a , b) -> (a[0] == b[0])? a[1] - b[1] : a[0] - b[0]);// O(nlogn)
        TreeMap<Integer, Integer> heightMap = new TreeMap<>(Collections.reverseOrder());
        heightMap.put(0, 1);//key is height, value is the # of this height occur
        int prevHeight = 0;

        List<int[]> skyLine = new LinkedList<>();
        for (int[] h: heights) {// O(nlogn)
            if (h[1] < 0) {
                Integer cnt = heightMap.get(-h[1]);
                cnt = (cnt == null) ? 1: cnt + 1;
                heightMap.put(-h[1], cnt); // O(logn)
            } else {
                Integer cnt = heightMap.get(h[1]);
                if (cnt == 1) {
                    heightMap.remove(h[1]);// O(logn)
                } else {
                    heightMap.put(h[1], cnt - 1);// O(logn)
                }
            }
            int currHeight = heightMap.firstKey();
            // Since it's reverseOrder,
            // it will return the maximal height
            if (prevHeight != currHeight) {
                skyLine.add(new int[]{h[0], currHeight});
                prevHeight = currHeight;
            }
        }
        return skyLine;

    }
}
