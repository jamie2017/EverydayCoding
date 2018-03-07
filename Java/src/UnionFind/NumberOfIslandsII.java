package UnionFind;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by JMYE on 8/27/16.
 */
public class NumberOfIslandsII {
    int converttoId(int x, int y, int m) {
        return x * m + y;
    }
    class UnionFind {
        HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();

        UnionFind(int n, int m) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int id = converttoId(i, j, m);
                    father.put(id, id);
                }
            }
        }

        int compressed_find(int x) {
            int parent = father.get(x);
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }
            int next;
            while (x != father.get(x)) {
                next = father.get(x);
                father.put(x, parent);
                x = next;
            }
            return parent;
        }

        void union(int x, int y) {
            int fa_x = compressed_find(x);
            int fa_y = compressed_find(y);
            if (fa_x != fa_y)
                father.put(fa_x, fa_y);
        }
    }

    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> ans = new ArrayList<Integer>();
        if (operators == null) {
            return ans;
        }

        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        int[][] island  = new int[n][m];
        UnionFind uf = new UnionFind(n,m);
        int count = 0;

        for(int i = 0; i < operators.length; i++) {
            count ++;
            int x = operators[i].x;
            int y = operators[i].y;
            if(island[x][y] != 1){
                island[x][y]  = 1;
                int id = converttoId(x,y , m);
                for(int j = 0 ; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if(0 <= nx && nx < n && 0 <= ny && ny < m && island[nx][ny] == 1)
                    {
                        int nid = converttoId(nx, ny, m);

                        int fa = uf.compressed_find(id);
                        int nfa = uf.compressed_find(nid);
                        if(fa != nfa) {
                            count--;
                            uf.union(id, nid);
                        }
                    }
                }
            }
            ans.add(count);
        }
        return ans;

    }


    // leetcode
    public List<Integer> numIslands2_leet(int m, int n, int[][] positions) {
        boolean[][] map = new boolean[m][n];
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        List<Integer> list = new ArrayList<Integer>();
        int island = 0;
        int[] fa = new int[m * n];

        //initialization
        for (int i = 0; i < m * n; i++) {
            fa[i] = i;
        }

        for (int i = 0; i < positions.length; i++) {
            island++;
            map[positions[i][0]][positions[i][1]] = true;
            int x, y;
            int f = positions[i][0] * n + positions[i][1];
            for (int k = 0; k < 4; k++) {
                x = positions[i][0] + dir[k][0];
                y = positions[i][1] + dir[k][1];
                if (x >= 0 && x < m && y >=0 && y < n && map[x][y] && getfather(fa, x * n + y) != f) {
                    fa[getfather(fa, x * n + y)] = f;
                    island--;
                }
            }
            list.add(island);
        }
        return list;
    }

    //disjoint-set and path compression
    public int getfather(int[] fa, int i) {
        if (fa[i] == i) {
            return i;
        }
        fa[i] = getfather(fa, fa[i]);//path compression here
        return fa[i];
    }
}
