package HighFrequency.TopK.MultipleSolutions;

import java.util.*;

/**
 * Created by JMYE on 11/23/16.
 */
public class EvaluateDivision {
    /*
    equations = [ ["a", "b"], ["b", "c"] ],
    values = [2.0, 3.0],
    queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
     */

    // Solution 1: Graph + DFS
    class Edge{
        String to;
        double weight;
        Edge(String t, double w){
            to = t;
            weight = w;
        }
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<Edge>> adjs = new HashMap<>();
        int edgeCnt = equations.length;
        for (int i = 0; i < edgeCnt; i++) {
            if (!adjs.containsKey(equations[i][0])) {
                adjs.put(equations[i][0], new ArrayList<>());
                adjs.get(equations[i][0]).add(new Edge(equations[i][1], values[i]));
            } else {
                adjs.get(equations[i][0]).add(new Edge(equations[i][1], values[i]));
            }

            if (!adjs.containsKey(equations[i][1])) {
                adjs.put(equations[i][1], new ArrayList<>());
                adjs.get(equations[i][1]).add(new Edge(equations[i][0], 1.0/values[i]));
            } else {
                adjs.get(equations[i][1]).add(new Edge(equations[i][0], 1.0/values[i]));
            }
        }
        int queryCnt = queries.length;
        double[] rst = new double[queryCnt];
        for (int i = 0; i < queryCnt; i++) {
            String s = queries[i][0];
            String t = queries[i][1];
            Set<String> visited = new HashSet();// because it's like a directed graph,
                                                // will cause cycle problem if not check visited points
            dfs(adjs,visited, s, t, 1.0,i, rst);
            if(rst[i] == 0 && s != t) rst[i] = -1.0;
        }

        return rst;
    }

    private void dfs(Map<String, List<Edge>> adjs,
                     Set<String> visited,
                     String s, String  t,
                     double distance, int index, double[] res){
        if(s.equals(t)) {
            res[index]  = distance;
        }
        if(visited.contains(s)) return;
        visited.add(s);
        if(!adjs.containsKey(s) || !adjs.containsKey(t)) {
            res[index] = -1.0;
            return;
        }
        List<Edge> adjsV = adjs.get(s);
        Iterator<Edge> iter = adjsV.iterator();
        while(iter.hasNext()){
            Edge e = iter.next();
            dfs(adjs,visited, e.to, t, distance * e.weight,index, res);
        }
    }


    // solution 2: Union Find


    public static void main(String[] args) {
        String[][] equations = { {"a", "b"}, {"b", "c"} };
        double[] values = {2.0, 3.0};
        String[][] queries = { {"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        EvaluateDivision test = new EvaluateDivision();
        double[] result = test.calcEquation(equations,values,queries);
        //[6.0, 0.5, -1.0, 1.0, -1.0 ]
        for (double r: result) {
            System.out.print(r + " ");
        }
    }
}
