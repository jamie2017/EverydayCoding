package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by JMYE on 9/16/16.
 */
public class kthSmallestElementinsSortedMatrix {
    // heap
    class Tuple implements Comparable<Tuple> {
        int x, y, val;
        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple that) {
            return this.val - that.val;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> heap = new PriorityQueue<>();
        int bound = matrix[0].length < k ? matrix[0].length : k;
        for(int j = 0; j < bound; j++)  {
            heap.offer(new Tuple(0, j, matrix[0][j]));
        }
        for (int i = 0; i < k - 1;i++) { // Note there is k - 1
            Tuple t = heap.poll();
            if (t.x == matrix.length - 1) continue;
            heap.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }
        return heap.poll().val; // so that the kth is still in heap, as the peek() one
    }

    // binary search // better solution since the matrix is sorted!!!!
    // this matrix is nXn
    public int kthSmallest_bs(int[][] matrix, int k) {
        int n = matrix.length;
        int L = matrix[0][0], R = matrix[n - 1][n - 1];
        while (L < R) {
            int mid = L + ((R - L) >> 1);
            int temp = search_lower_than_mid(matrix, n, mid);
            if (temp < k) L = mid + 1;
            else R = mid;
        }
        return L;
    }
    // return how many value smaller then middle value in the matrix
    private int search_lower_than_mid(int[][] matrix,int n,int x) {
        int i = n - 1, j = 0, cnt = 0; // start from left bottom corner
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= x) {
                j++;
                cnt += i + 1; // all this columns value <= x
            }
            else i--;
        }
        return cnt;
    }
}
