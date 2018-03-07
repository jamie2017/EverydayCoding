package UnionFind;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JMYE on 9/18/16.
 */
public class NumberofConnectedComponentsinUndirectedGraph {
     private int[] father;

     public int countComponents(int n, int[][] edges) {
         Set<Integer> set = new HashSet<Integer>();
         father = new int[n];
         for (int i = 0; i < n; i++) {
             father[i] = i;
         }
         for(int i = 0; i < edges.length;i++) {
             union(edges[i][0],edges[i][1]);
         }
         //find father for each node, use set because some node share same father
         //nodes within one connected components comes from one same father
         for (int i = 0; i < n; i++) {
             set.add(find(i));
         }
         return set.size();

     }


     private int find(int node) {
         if (father[node] == node) {
             return node;
         }
         father[node] = find(father[node]);
         return father[node];
     }
     private void union(int node1, int node2) {
         father[find(node1)] = find(node2);
     }
}
