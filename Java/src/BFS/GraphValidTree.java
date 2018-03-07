package BFS;

import java.util.*;

/**
 * Created by JMYE on 9/8/16.
 */


public class GraphValidTree { // MARK
 // bfd
 public boolean validTree_BFS(int n, int[][] edges) {
     int[] visited = new int[n];
     List<Set<Integer>> graph = new ArrayList<>(n);
     for(int i = 0; i < n; i ++){
         graph.add(new HashSet<Integer>());
     }
     for(int[] edge : edges){
         graph.get(edge[1]).add(edge[0]);
         graph.get(edge[0]).add(edge[1]);
     }
     Queue<Integer> q = new LinkedList<>();
     q.offer(0);
     visited[0] = 1;
     int count = 0;
     while(!q.isEmpty()){
         int vertex = q.poll();
         count ++;
         for(int neighbor : graph.get(vertex)){
             if(visited[neighbor] == 1){
                 return false;
             }
             graph.get(neighbor).remove(vertex);
             visited[neighbor] = 1;
             q.offer(neighbor);

         }
     }
     //return true;
     return count == n;
 }


    // DFS
    public boolean validTree(int n, int[][] edges) {
        // initialize adjacency list
        List<List<Integer>> adjList = new ArrayList<List<Integer>>(n);

        // initialize vertices
        for (int i = 0; i < n; i++)
            adjList.add(i, new ArrayList<Integer>());

        // add edges
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        // make sure there's no cycle
        if (hasCycle(adjList, 0, visited, -1))
            return false;

        // make sure all vertices are connected
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                return false;
        }

        return true;
    }

    // check if an undirected graph has cycle started from vertex u
    boolean hasCycle(List<List<Integer>> adjList, int u, boolean[] visited, int parent) {
        visited[u] = true;

        for (int i = 0; i < adjList.get(u).size(); i++) {
            int v = adjList.get(u).get(i);

            if ((visited[v] && parent != v) || (!visited[v] && hasCycle(adjList, v, visited, u)))
                return true;
        }

        return false;
    }

}
