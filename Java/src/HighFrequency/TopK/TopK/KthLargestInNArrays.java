package HighFrequency.TopK.TopK;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by JMYE on 11/20/16.
 */
public class KthLargestInNArrays {
    static class Node {
        public int val, arrayId, index;
        public Node (int val, int arrayId, int index) {
            this.val = val;
            this.arrayId = arrayId;
            this.index = index;
        }
    }
    public int KthInArrays(int[][] arrays, int k) {// MARK
        Queue<Node> maxHeap = new PriorityQueue<>(k, (a,b)->b.val - a.val);
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == null || arrays[i].length == 0) {
                continue;
            }
            Arrays.sort(arrays[i]);
            maxHeap.offer(new Node(arrays[i][arrays[i].length - 1], i, arrays[i].length - 1));
        }

        for (int i = 0; i < k; i++) {
            Node tmp = maxHeap.poll();
            if (i == k - 1) {
                return tmp.val;
            }
            if (tmp.index > 0) {
                maxHeap.add(new Node(arrays[tmp.arrayId][tmp.index - 1], tmp.arrayId, tmp.index - 1));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[][] arrays = {{9,3,2,4,7},{1,2,3,4,8}};
        int[][] arrays = {{},{9,3,2,4,8},{1,2,3,4,2}};
        int k = 2;
        KthLargestInNArrays test = new KthLargestInNArrays();
        System.out.println(test.KthInArrays(arrays, k));
    }
}
