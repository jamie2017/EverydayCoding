package Heap;

/**
 * Created by JMYE on 8/27/16.
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class KthInArrays {
    class Node {
        public int value, from_id, index;
        public Node(int _v, int _id, int _i) {
            this.value = _v;
            this.from_id = _id;
            this.index = _i;
        }
    }
    public int KthInArrays(int[][] arrays, int k) {// MARK
        Queue<Node> queue = new PriorityQueue<Node>(k, new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                return o2.value - o1.value;
            }
        });

        int n = arrays.length;
        int i;
        for (i = 0; i < n; ++i) { // initial some value to heap, add the largest number in each arrays
            Arrays.sort(arrays[i]);
            if (arrays[i].length > 0) {
                int from_id = i;
                int index = arrays[i].length - 1;
                int value = arrays[i][index];
                queue.add(new Node(value, from_id, index));
            }
        }

        for (i = 0; i < k; ++i) {
            Node temp = queue.poll();
            int from_id = temp.from_id;
            int index = temp.index;
            int value = temp.value;

            if (i == k - 1)
                return value;

            if (index > 0) {
                index --;
                value = arrays[from_id][index];
                queue.add(new Node(value, from_id, index));
            }
        }
        return -1;

    }



    public static void main(String[] args) {
        int[][] arrays = {{11},{1,2,3,4,112,87},{564},{789,12,15}};
        int k = 7;
        KthInArrays test = new KthInArrays();
        System.out.println(test.KthInArrays(arrays,k));
    }
}
