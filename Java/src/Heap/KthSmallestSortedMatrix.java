package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by JMYE on 8/20/16.
 */


public class KthSmallestSortedMatrix {   //O(klogk)

    class Cell{
        public int x, y,val;
        public Cell(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public int[][] direction = {{0,1},{1,0}};
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return -1;
        }
        if (matrix.length * matrix[0].length < k) {
            return -1;
        }
        Queue<Cell> heap = new PriorityQueue<>(k, new Comparator<Cell>(){
            @Override
            public int compare(Cell a, Cell b) {
                return a.val - b.val;
            }
        });
        int rows = matrix.length, cols = matrix[0].length;
        boolean[][] visit = new boolean[rows][cols];

        heap.offer(new Cell(0,0,matrix[0][0]));
        visit[0][0] = true;

        for (int i = 0 ; i < k - 1; i++) {
            Cell tmp = heap.poll();
            int tmp_x = tmp.x;
            int tmp_y = tmp.y;

            for (int[] dir : direction) {
                int dx = tmp_x + dir[0];
                int dy = tmp_y + dir[1];
                if (0 <= dx && dx < rows && 0 <= dy && dy < cols && !visit[dx][dy]) {
                    visit[dx][dy] = true;
                    heap.offer(new Cell(dx, dy, matrix[dx][dy]));
                }


            }
        }
        return heap.peek().val;
    }

    public static void main (String[] args) {
        int[][] matrix = {{1,5,9},
                         {10,11,13},
                         {12,13,15}};
        KthSmallestSortedMatrix test = new KthSmallestSortedMatrix();
        System.out.println(test.kthSmallest(matrix,8));
    }
}