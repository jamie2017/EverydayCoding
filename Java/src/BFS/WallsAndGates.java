package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by JMYE on 7/14/17.
 * 286. Walls and Gates
 */
public class WallsAndGates {
    class PosNode {
        int r,c;
        public PosNode(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private final static int[] dirX = {0,0,-1,1};
    private final static int[] dirY = {1,-1,0,0};
    private final static int INF = 2147483647;
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        Queue<PosNode> queue = new LinkedList<>();
        // Set<String> visited = new HashSet<>();
        int row = rooms.length, col = rooms[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col;j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new PosNode(i,j));
                    // visited.add(i +","+j);
                }
            }
        }
        while (!queue.isEmpty()) {
            PosNode cur = queue.poll();
            for (int d = 0; d < dirX.length; d++) {
                int x = cur.r + dirX[d];
                int y = cur.c + dirY[d];
                if (0 <= x && x < row && 0 <= y && y < col
                        && rooms[x][y] == INF){
                    // && rooms[x][y] != -1 && !visited.contains(x +","+y)) {
                    rooms[x][y] = rooms[cur.r][cur.c] + 1;
                    queue.offer(new PosNode(x,y));
                    // visited.add(x +","+y);
                }
            }
        }
    }
}
