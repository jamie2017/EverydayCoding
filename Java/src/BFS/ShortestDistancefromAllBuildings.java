package BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by JMYE on 9/22/16.
 */
public class ShortestDistancefromAllBuildings {
    int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    class DistTuple {
        public int x,y,dist;
        public DistTuple(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid[0] == null) return -1;
        int R = grid.length, C = grid[0].length;
        int buildings = 0;
        int[][] hit = new int[R][C];
        int[][] distSum = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1) buildings++;
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1) {
                    if (!bfs(i,j,grid,hit,distSum,buildings,R,C)) return -1;
                }
            }
        }
        int minDist = Integer.MAX_VALUE;
        for(int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(grid[i][j] == 0 && hit[i][j] == buildings) {
                    minDist = Math.min(distSum[i][j], minDist);
                }
            }
        }
        return minDist == Integer.MAX_VALUE? -1:minDist;
    }

    private boolean bfs(int startX, int startY, int[][] grid, int[][] hit, int[][] distSum, int buildings, int R, int C) {
        boolean[][] visited = new boolean[R][C];
        visited[startX][startY] = true;
        int buildingCnt = 1;
        Queue<DistTuple> queue = new ArrayDeque<>();
        queue.add(new DistTuple(startX, startY,0));
        while (!queue.isEmpty()) {
            DistTuple t = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = t.x + dx[i], y = t.y + dy[i];
                if (0 <= x && x < R && 0 <= y && y < C && !visited[x][y]) {
                    visited[x][y] = true;
                    if (grid[x][y] == 0) {
                        queue.add(new DistTuple(x,y,t.dist + 1));
                        hit[x][y] ++;
                        distSum[x][y] += t.dist + 1;
                    } else if (grid[x][y] == 1) {
                        buildingCnt ++;
                    }
                }
            }
        }
        return buildingCnt == buildings;
    }
}
