package Heap;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Created by JMYE on 8/27/16.
 */
// MARK

//class Pair implements Comparable<Pair> {
//    int x;
//    int y;
//    int sum;
//    Pair(int x, int y, int sum) {
//        this.x = x;
//        this.y = y;
//        this.sum = sum;
//    }
//    @Override
//    public int compareTo(Pair another) {
//        if (this.sum == another.sum) {
//            return 0;
//        }
//        return this.sum < another.sum ? -1 : 1;
//    }
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == this) {
//            return true;
//        } else if (!(obj instanceof Pair)) {
//            return false;
//        }
//        Pair another = (Pair) obj;
//        return this.x == another.x && this.y == another.y;
//    }
//    @Override
//    public int hashCode() {
//        return x * 101 + y;
//    }
//}
//public class KthSmallestSumTwoSortedArrays {
//    int[] dx = {1, 0};
//    int[] dy = {0, 1};
//    public int kthSmallestSum(int[] A, int[] B, int k) {
//        if (A.length == 0 && B.length == 0) {
//            return 0;
//        } else if (A.length == 0) {
//            return B[k];
//        } else if (B.length == 0) {
//            return A[k];
//        }
//        HashSet<Pair> isVisited = new HashSet<Pair>();
//        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>();
//        Pair p;
//        Pair nextP;
//        p = new Pair(0, 0, A[0] + B[0]);
//        minHeap.offer(p);
//        isVisited.add(p);
//        int nextX;
//        int nextY;
//        int nextSum;
//        for (int count = 0; count < k - 1; count++) {
//            p = minHeap.poll();
//            for (int i = 0; i < 2; i++) {
//                nextX = p.x + dx[i];
//                nextY = p.y + dy[i];
//                nextP = new Pair(nextX, nextY, 0);
//                if (nextX >= 0 && nextX < A.length && nextY >= 0 && nextY < B.length && !isVisited.contains(nextP)) {
//                    nextSum = A[nextX] + B[nextY];
//                    nextP.sum = nextSum;
//                    minHeap.offer(nextP);
//                    isVisited.add(nextP);
//                }
//            }
//        }
//        return minHeap.peek().sum;
//    }



class KthSmallestSumTwoSortedArrays {
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


    int dx[] = {0,1};
    int dy[] = {1,0};

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
            if (cur.x == row -1) continue;
            heap.add(new Pair(cur.x + 1,cur.y, A[cur.x + 1] + B[cur.y]));
        }
        return heap.peek().sum;
    }




    public static void main(String[] args) {
        int[] A = {1,7,11};
        int[] B = {2,4,6};
        int k = 8;
        KthSmallestSumTwoSortedArrays test = new KthSmallestSumTwoSortedArrays();
        System.out.println(test.kthSmallestSum(A,B,k));
    }
}