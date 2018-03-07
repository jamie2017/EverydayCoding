package UnionFind;

import java.util.*;

/**
 * Created by JMYE on 8/28/16.
 */
public class SurroundedRegions { // MARK
    // BFS
    class PosNode {
        int i,j;
        public PosNode(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    static final int[] directionX = {+1, -1, 0, 0};
    static final int[] directionY = {0, 0, +1, -1};
    public void solve(char[][] board) {
        if(board == null || board.length == 0) {
            return;
        }
        int row = board.length, col = board[0].length;
        Queue<PosNode> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            queue.offer(new PosNode(i,0));
            queue.offer(new PosNode(i, col - 1));
        }
        for (int j = 1; j < col - 1; j++) {
            queue.offer(new PosNode(0,j));
            queue.offer(new PosNode(row - 1, j));
        }
        while (!queue.isEmpty()) {
            PosNode pos = queue.poll();
            if (pos.i >= 0 && pos.i < row && pos.j >= 0 && pos.j < col && board[pos.i][pos.j] == 'O') {
                board[pos.i][pos.j] = 'M';
                for (int k = 0; k < directionX.length; k++) {
                    int x = pos.i + directionX[k];
                    int y = pos.j + directionY[k];
                    queue.offer(new PosNode(x,y));
                }
            }
        }
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (board[r][c] == 'M') {
                    board[r][c] = 'O';
                } else {
                    board[r][c] = 'X';
                }
            }
        }
    }


    // Version 2
    private static Queue<Integer> queue = null;
    private static char[][] board;
    private static int rows = 0;
    private static int cols = 0;

    public void surroundedRegions(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (board.length == 0 || board[0].length == 0) return;
        queue = new LinkedList<Integer>();
        board = board;
        rows = board.length;
        cols = board[0].length;

        for (int i = 0; i < rows; i++) { // **important**
            enqueue(i, 0);
            enqueue(i, cols - 1);
        }

        for (int j = 1; j < cols - 1; j++) { // **important**
            enqueue(0, j);
            enqueue(rows - 1, j);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int x = cur / cols,
                    y = cur % cols;

            if (board[x][y] == 'O') {
                board[x][y] = 'D';
            }

            enqueue(x - 1, y);
            enqueue(x + 1, y);
            enqueue(x, y - 1);
            enqueue(x, y + 1);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'D') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }

        queue = null;
        board = null;
        rows = 0;
        cols = 0;
    }

    public static void enqueue(int x, int y) {
        if (x >= 0 && x < rows && y >= 0 && y < cols && board[x][y] == 'O'){
            queue.offer(x * cols + y);
        }
    }
}
