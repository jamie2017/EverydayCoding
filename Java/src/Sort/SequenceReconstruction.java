package Sort;

import java.util.*;

/**
 * Created by JMYE on 11/15/16.
 */
public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, int[][] seqs) { // topological sort
        /*
        False:
        not equals unique int
        not unique path
        not shortest path
         */

        Map<Integer, Integer> inMap = new HashMap<>();
        Map<Integer, List<Integer>> outMap = new HashMap<>();
        for (int[] seq : seqs) {
            for (int i = 0; i < seq.length; i++) {
                outMap.putIfAbsent(seq[i], new ArrayList<>());
                inMap.putIfAbsent(seq[i], 0);
                if (i > 0) {
                    outMap.get(seq[i - 1]).add(seq[i]);
                    inMap.put(seq[i], inMap.get(seq[i]) + 1);
                }
            }
        }

        if (org.length != inMap.size()) return false;


        Queue<Integer> queue = new LinkedList<>();

        for (Integer key : inMap.keySet()) {
            if (inMap.get(key) == 0) {
                queue.offer(key);
            }
        }

        int idx = 0;
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }
            int curr = queue.poll();
            if (org[idx++] != curr) {
                return false;
            }

            for (int nextN : outMap.get(curr)) {
                inMap.put(nextN, inMap.get(nextN) - 1);
                if (inMap.get(nextN) == 0) {
                    queue.offer(nextN);
                }
            }
        }
        return idx == org.length;
    }
}
