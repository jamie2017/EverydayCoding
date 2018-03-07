package BFS;

import javafx.geometry.Pos;

import java.util.*;

/**
 * Created by JMYE on 7/15/17.
 */
public class RestoreMatrix {
    class PosNode{
        int i, j;
        int step;
        List<String> path = new ArrayList<>();
        public PosNode(int i, int j) {
            this.i = i;
            this.j = j;
            this.step = 0;
        }
        public PosNode(int i, int j,int step) {
            this.i = i;
            this.j = j;
            this.step = step;
        }
        public void addPath(String p) {
            this.path.add(p);
        }
    }

    static final int[][] dirXY = {{1,0},{-1,0},{0,1},{0,-1}};
    static final String[] dirKey = {"Down","Up","Right","Left"};

    public int restoreMatrix(int[][] matrix, int block) {
        int restoreCnt = 0;
        int row = matrix.length, col = matrix[0].length;
        int[] trueTable = new int[row*col];
        for (int i = 0; i < row * col; i++) {
            trueTable[i] = i+1;
        }
        trueTable[block - 1] = -1;
        int startPoint = 1;
        boolean done;
//        int runs = 0;
        while(true) {
//            runs ++;
            PosNode startIdx = getStartIndex(matrix,startPoint,row,col);
            PosNode endIdx = getEndIndex(trueTable,startPoint,col,block);
            List<String> path = moveByBFS(matrix,startIdx,endIdx);
            if (path != null || path.size() != 0) {
                restoreCnt += path.size();
                updateMatrix(matrix,path,startIdx.i, startIdx.j);
                done = true;
                for (int r = 0; r < row; r++) {
//                    System.out.println(Arrays.toString(matrix[r]));
                    for (int c = 0; c < col; c++) {
                        if (matrix[r][c] != trueTable[r*col+c]) {
                            startPoint = trueTable[r*col+c];
                            done = false;
                            break;
                        }
                    }
                }
                if (done) break;
//                System.out.println();
            }
        }
//        System.out.println(">>>> " + runs);
        return restoreCnt;


    }

    private void updateMatrix(int[][] matrix, List<String> path, int i, int j) {
        for (int p = 0; p < path.size(); p++) {
            for (int d = 0; d < 4; d++) {
                if (path.get(p).equals(dirKey[d])) {
                    int ni = i + dirXY[d][0];
                    int nj = j + dirXY[d][1];
                    swap(matrix,i,j,ni,nj);
                    i = ni;
                    j = nj;
                    break;
                }
            }
        }

    }

    private void swap(int[][] matrix, int i, int j, int ni, int nj) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[ni][nj];
        matrix[ni][nj] = tmp;
    }

    private List<String> moveByBFS(int[][] matrix, PosNode startIdx, PosNode endIdx) {
        Queue<PosNode> queue = new LinkedList<>();
        queue.offer(startIdx);
        PosNode cur;
        Set<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                 cur = queue.poll();
                 if (cur.i == endIdx.i && cur.j == endIdx.j) {
                     return cur.path;
                 }
                 for (int k = 0; k < dirXY.length; k++) {
                     int ni = cur.i + dirXY[k][0];
                     int nj = cur.j + dirXY[k][1];
                     if (0 <= ni && ni < matrix.length && 0 <= nj && nj < matrix[0].length && !visited.contains(ni + " " + nj)) {
                         visited.add(ni + " " + nj);
                         PosNode nextNode = new PosNode(ni,nj,cur.step + 1);
                         nextNode.addPath(dirKey[k]);
                         queue.offer(nextNode);
                     }
                 }

            }
        }
        return null;
    }

    private PosNode getStartIndex(int[][] matrix, int target,int row, int col) {
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (matrix[r][c] == target) {
                    return new PosNode(r,c);
                }
            }
        }
        return null;
    }

    private PosNode getEndIndex(int[] trueTable,int target, int col, int block) {
        if (target == -1) target = block;
        return new PosNode((target - 1)/col,(target - 1)%col);
    }

    public static void main(String[] args) {
        RestoreMatrix test = new RestoreMatrix();
        int[][] mtx = {{4,5,6},{1,3,7},{2,-1,8}};
        System.out.println(test.restoreMatrix(mtx,9));
        int[][] mtx2 = {{5,3,2,1},{4,9,8,7},{-1,14,15,13},{6,10,16,12}};
        System.out.println(test.restoreMatrix(mtx2,11));

        int[][] mtx3= {{2,16,3,11},{10,15,7,6},{14,4,9,8},{-1,5,1,13}};
        System.out.println(test.restoreMatrix(mtx3,12));

        int[][] mtx4= {{2,16,3,11,17},{10,15,7,6,18},{14,4,9,8,19},{12,5,1,-1,21},{20,25,23,24,22}};
        System.out.println(test.restoreMatrix(mtx4,13));

    }
}
