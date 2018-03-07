package HighFrequency.TopK.TopK;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by JMYE on 11/20/16.
 */
public class KthSmallestPairInTwoArrays {
    class Pair {
        public int x, y, sum;
        public Pair(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }
    class PairComparator implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            return a.sum - b.sum;
        }
    }


    public int kthSmallestSum(int[] A, int[] B, int k)  {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return -1;
        }
        int row = A.length;
        int col = B.length;

        k = k > row * col ? row * col : k;
        PriorityQueue<Pair> heap = new PriorityQueue<Pair>(k, new PairComparator());

        for(int i = 0; i < col; i++) {
            heap.add(new Pair(0,i,A[0] + B[i]));
        }

        for (int i = 0; i < k - 1; i ++) {
            Pair cur = heap.poll();
            if (cur.x == row - 1) continue;
            heap.add(new Pair(cur.x + 1,cur.y, A[cur.x + 1] + B[cur.y]));
        }
        return heap.peek().sum;
    }
}
