package DFS;

import UnionFind.UnionFind;

/**
 * Created by JMYE on 8/27/16.
 */
public class NumberOfIslands {

    //dfs
    private int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    private int m,n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        if (m == 0) return 0;
        n = grid[0].length;
        if (n == 0) return 0;

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                ans++;
                dfs(grid, i, j);
            }
        }
        return ans;
    }

    public void dfs(char[][] grid, int i, int j){
        if (i < 0 || i >= m || j < 0 || j >= n) return ;

        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            for (int[] d: direction) {
                int x = i + d[0];
                int y = j + d[1];
                dfs(grid,x,y);
            }

        }
    }


    // union find

//    private int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};

    public int numIslands_uf(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        UnionFind uf = new UnionFind(grid);
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    for(int[] d : direction) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < rows && y >=0 && y < cols && grid[x][y] == '1') {
                            int id1 = i * cols + j;
                            int id2 = x * cols + y;
                            uf.union(id1, id2);

                        }

                    }
                }
            }
        }
        return uf.count;
    }
}
