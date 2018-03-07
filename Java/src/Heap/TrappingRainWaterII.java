package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by JMYE on 8/28/16.
 */


// 1) 找外围向内
// 2) 找最小=》 Heap
// 3) 找没遍历的(上下左右)

public class TrappingRainWaterII {
    class Cell{
        public int x, y, h;
        Cell(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
    class CellComparator implements Comparator<Cell>{
        @Override
        public int compare(Cell a, Cell b) {
            return a.h - b.h;
        }
    }
    private int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2) {
            return 0;
        }
        PriorityQueue<Cell> heap = new PriorityQueue<>(1, new CellComparator());
        int rows = heightMap.length;
        int cols = heightMap[0].length;
        int[][] visit = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            heap.offer(new Cell(i,0,heightMap[i][0]));
            heap.offer(new Cell(i, cols - 1, heightMap[i][cols - 1]));
            visit[i][0] = 1;
            visit[i][cols - 1] = 1;
        }

        for (int i = 0; i < cols; i++) {
            heap.offer(new Cell(0,i,heightMap[0][i]));
            heap.offer(new Cell(rows - 1, i,heightMap[rows - 1][i]));
            visit[0][i] = 1;
            visit[rows - 1][i] = 1;
        }
        int rst = 0;
        while(!heap.isEmpty()){
            Cell cur = heap.poll();
            for (int[] dir : direction) {
                int cur_x = cur.x + dir[0];
                int cur_y = cur.y + dir[1];
                if (0 <= cur_x && cur_x < rows && 0 <= cur_y && cur_y < cols && visit[cur_x][cur_y] == 0) {
                    visit[cur_x][cur_y] = 1;
                    heap.offer(new Cell(cur_x, cur_y, Math.max(cur.h,heightMap[cur_x][cur_y])) ); // Note here
                    // this handle the problem like
                    /*
                    9 9 9 9 9 9 8 9 9 9 9
                    9 0 0 0 0 0 1 0 0 0 9
                    9 0 0 0 0 0 0 0 0 0 9
                    9 0 0 0 0 0 0 0 0 0 9
                    9 9 9 9 9 9 9 9 9 9 9

                    After you process 8, the downward 1 will be replaced as 8, instead of 1 as height.

                     */
                    rst += Math.max(0, cur.h - heightMap[cur_x][cur_y]);
                }
            }
        }
        return rst;
    }

}