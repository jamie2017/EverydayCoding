package HighFrequency.TopK.TopK;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by JMYE on 11/20/16.
 */
public class KthSmallestNumberinSortedMatrix {
    static class Node {
        public int val, arrayId, index;
        public Node (int val, int arrayId, int index) {
            this.val = val;
            this.arrayId = arrayId;
            this.index = index;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Node> minHeap = new PriorityQueue<>(k, (a, b)->a.val - b.val);
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == null || matrix[i].length == 0) {
                continue;
            }
            Arrays.sort(matrix[i]);
            minHeap.offer(new Node(matrix[i][0], i, 0));
        }

        for (int i = 0; i < k; i++) {
            Node tmp = minHeap.poll();
            if (i == k - 1) {
                return tmp.val;
            }
            if (tmp.index < matrix[tmp.arrayId].length - 1) {
                minHeap.add(new Node(matrix[tmp.arrayId][tmp.index + 1], tmp.arrayId, tmp.index + 1));
            }
        }
        return -1;
    }

    // solution 2: binary search
    public int kthSmallest_binarySearch(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int L = matrix[0][0], R = matrix[n - 1][m - 1];
        while (L < R) {
            int mid = L + ((R - L) >> 1);
            int temp = search_lower_than_mid(matrix, n,m, mid);
            if (temp < k) L = mid + 1;
            else R = mid;
        }
        return L;
    }
    // return how many value smaller then middle value in the matrix
    private int search_lower_than_mid(int[][] matrix,int n, int m, int x) {
        int i = n - 1, j = 0, cnt = 0; // start from left bottom corner
        while (i >= 0 && j < m) {
            if (matrix[i][j] <= x) {
                j++;
                cnt += i + 1; // all this columns value <= x
            }
            else i--;
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,5,7},{3,7,8},{4,8,9}};
        int k = 4;
        KthSmallestNumberinSortedMatrix test = new KthSmallestNumberinSortedMatrix();
        System.out.println(test.kthSmallest(matrix,k));
    }

}
