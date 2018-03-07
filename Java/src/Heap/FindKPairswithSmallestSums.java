package Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by JMYE on 9/28/16.
 */
public class FindKPairswithSmallestSums {

    /*

     2   4   6
   +------------
 1 |  3   5   7
 7 |  9  11  13
11 | 13  15  17

def kSmallestPairs(self, nums1, nums2, k):
    return map(list, sorted(itertools.product(nums1, nums2), key=sum)[:k])

def kSmallestPairs(self, nums1, nums2, k):
    return map(list, heapq.nsmallest(k, itertools.product(nums1, nums2), key=sum))

def kSmallestPairs(self, nums1, nums2, k):
    streams = map(lambda u: ([u+v, u, v] for v in nums2), nums1)
    stream = heapq.merge(*streams)
    return [suv[1:] for suv in itertools.islice(stream, k)]
     */


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

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k)  {
        List<int[]> rst = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return rst;
        }
        int row = nums1.length;
        int col = nums2.length;

        k = k > row * col ? row * col : k;
        PriorityQueue<Pair> heap = new PriorityQueue<Pair>(k, new PairComparator());
        boolean[][] hash = new boolean[row][col];
        heap.add(new Pair(0, 0, nums1[0]+nums2[0]));
        hash[0][0] = true;

        for (int i = 0; i < k; i ++) {
            Pair smallest = heap.poll();
            int[] tmp = new int[2];
            tmp[0] = nums1[smallest.x];
            tmp[1] = nums2[smallest.y];
            rst.add(tmp);
            for (int j = 0; j < 2; j++) {
                int nx = smallest.x + dx[j];
                int ny = smallest.y + dy[j];
                if(nx < row && ny < col && !hash[nx][ny]) {
                    hash[nx][ny] = true;
                    heap.add(new Pair(nx, ny, nums1[nx]+nums2[ny]));
                }
            }
        }
        return rst;
    }




}
