package ByComs.Amazon.OnlineAssessment;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by JMYE on 10/10/16.
 */
public class Maze {
    private final static int[] dx = {-1, 0, 0, 1};
    private final static int[] dy = {0, 1, -1, 0};
    public int findNine(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        if (matrix[0][0] == 9)
            return 1;
        if (matrix[0][0] == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] visited = new int[m][n];
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int[] next = {cur[0] + dx[i], cur[1] + dy[i]};
                if (next[0] >= 0 && next[0] < m && next[1] >= 0 && next[1] < n && visited[next[0]][next[1]] != 1) {
                    if (matrix[next[0]][next[1]] == 9)
                        return 1;
                    else if (matrix[next[0]][next[1]] == 1) {
                        queue.offer(next);
                        visited[next[0]][next[1]] = 1;
                    }
                }
            }
        }
        return 0;
    }

    public static void main (String[] args) {
        int[][] matrix = {{1,0,0},{1,1,0},{0,1,9}};
        Maze test = new Maze();
        System.out.println(test.findNine(matrix));
    }
}
