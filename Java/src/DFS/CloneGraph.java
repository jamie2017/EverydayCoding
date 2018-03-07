package DFS;

/**
 * Created by JMYE on 9/9/16.
 */

import BFS.UndirectedGraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Definition for undirected graph.


public class CloneGraph {
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    };
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return cloneGraph(node, new HashMap<UndirectedGraphNode, UndirectedGraphNode>());
    }

    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> cloneMap) {
        if (node == null) return null;
        UndirectedGraphNode cloned = new UndirectedGraphNode(node.label);
        cloneMap.put(node, cloned); // visited = true;
        for(UndirectedGraphNode neighbor: node.neighbors){
            if (cloneMap.containsKey(neighbor)) { // if we have already explored this vertex grab its clone from map
                cloned.neighbors.add(cloneMap.get(neighbor));
            } else { // explore unvisited vertex
                cloned.neighbors.add(cloneGraph(neighbor, cloneMap));
            }
        }
        return cloned;
    }
}
