package BFS;

import java.util.*;

/**
 * Created by JMYE on 8/27/16.
 */
public class ConnectedComponentUndirectedGraph {
//    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
//        // Write your code here
//
//        Map<UndirectedGraphNode, Boolean> visited = new HashMap<>();
//
//        for (UndirectedGraphNode node : nodes){
//            visited.put(node, false);
//        }
//
//        List<List<Integer>> result = new ArrayList<>();
//
//        for (UndirectedGraphNode node : nodes){
//            if (visited.get(node) == false){
//                bfs(node, visited, result);
//            }
//        }
//
//        return result;
//    }
//
//
//    public void bfs(UndirectedGraphNode node, Map<UndirectedGraphNode, Boolean> visited, List<List<Integer>> result){
//
//        List<Integer>row = new ArrayList<>();
//
//        Queue<UndirectedGraphNode> queue = new LinkedList<>();
//        visited.put(node, true);
//        queue.offer(node);
//
//        while (!queue.isEmpty()){
//            UndirectedGraphNode u = queue.poll();
//            row.add(u.label);
//
//            for (UndirectedGraphNode v : u.neighbors){
//                if (visited.get(v) == false){
//                    visited.put(v, true);
//                    queue.offer(v);
//                }
//            }
//        }
//
//        Collections.sort(row);
//        result.add(row);
//
//    }
}
