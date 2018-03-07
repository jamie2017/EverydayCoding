package UnionFind;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JMYE on 10/3/16.
 */
public class UnionFind {
    private Map<Integer, Integer> father = new HashMap<>();
    public int count = 0;
    public UnionFind(char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int id = i * n + j;
                    father.put(id,id);
                    count++;
                }
            }
        }
    }



    public int find(int x) {
        int parent = x;
        while (parent != father.get(parent)) {
            parent = father.get(parent);
        }
        return parent;
    }

    public void union(int x, int y) {
        int fa_x = find(x);
        int fa_y = find(y);
        if (fa_x != fa_y) {
            father.put(fa_x,fa_y);
            count--;
        }
    }
}
