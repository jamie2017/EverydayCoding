package BFS;

import java.util.*;

/**
 * Created by JMYE on 9/22/16.
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (adj.get(i).size() == 1) leaves.add(i);
        }
        System.out.println(leaves);

        while (n > 2) { // at most exists 2 mht tress
            n -= leaves.size(); // remove leaves layer by layer
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next(); // use iterator is because we don't konw the length of each adj list
                adj.get(j).remove(i); //!! Tree is undirected graph need to remove because adj was added both sides
                if (adj.get(j).size() == 1) { // !!
                    newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }
        return leaves;

    }

    public static void main(String[] argu) {
        MinimumHeightTrees test = new MinimumHeightTrees();
//        int[][] edges1 = {{1,0},{1,2},{1,3}};
//        int n1 = 4;
//        System.out.println(test.findMinHeightTrees(n1,edges1));
        int[][] edges1 = {{0,3},{1,3},{2,3},{4,3},{5,4}};
        int n1 = 6;
        System.out.println(test.findMinHeightTrees(n1,edges1));
    }
}
