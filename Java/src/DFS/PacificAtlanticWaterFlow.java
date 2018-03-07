package DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by JMYE on 11/26/16.
 */
public class PacificAtlanticWaterFlow {
    static int[][] dir = new int[][]{{0, 1},{0, -1},{1, 0},{-1, 0}};
    public List<int[]> pacificAtlantic_DFS(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int rows = matrix.length, cols = matrix[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            explore(matrix, pacific, Integer.MIN_VALUE, i, 0);// flow from left to right
            explore(matrix, atlantic, Integer.MIN_VALUE, i, cols - 1);// flow from right to left
        }
        for (int j = 0; j < cols; j++) {
            explore(matrix, pacific, Integer.MIN_VALUE, 0, j);// flow from up to down
            explore(matrix, atlantic, Integer.MIN_VALUE, rows - 1, j);// flow from down to up
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }

    private void explore(int[][]matrix, boolean[][] visited, int prevHeight,int i, int j) {
        int rows = matrix.length, cols = matrix[0].length;
        if (i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j] || matrix[i][j] < prevHeight) {
            return;
        }
        visited[i][j] = true;
        for (int[] d : dir) {
            explore(matrix, visited, matrix[i][j], i + d[0], j + d[1]);
        }
    }



    public List<int[]> pacificAtlantic_BFS(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int rows = matrix.length, cols = matrix[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        for(int i=0; i<rows; i++){ //Vertical border
            pQueue.offer(new int[]{i, 0});
            aQueue.offer(new int[]{i, cols-1});
            pacific[i][0] = true;
            atlantic[i][cols-1] = true;
        }
        for(int i=0; i<cols; i++){ //Horizontal border
            pQueue.offer(new int[]{0, i});
            aQueue.offer(new int[]{rows-1, i});
            pacific[0][i] = true;
            atlantic[rows-1][i] = true;
        }
        bfs(matrix, pQueue, pacific);
        bfs(matrix, aQueue, atlantic);
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(pacific[i][j] && atlantic[i][j])
                    res.add(new int[]{i,j});
            }
        }
        return res;
    }
    public void bfs(int[][]matrix, Queue<int[]> queue, boolean[][]visited){
        int n = matrix.length, m = matrix[0].length;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int[] d:dir){
                int x = cur[0]+d[0];
                int y = cur[1]+d[1];
                if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]]){
                    continue;
                }
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }
    public static void main(String[] args) {
        int [][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        PacificAtlanticWaterFlow test = new PacificAtlanticWaterFlow();
        for (int[] res: test.pacificAtlantic_DFS(matrix)) {
            System.out.println("[" + res[0] + ", " + res[1] + "]");
            System.out.println();
        }

    }
}
