package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by JMYE on 7/2/17.
 */
public class SmallestRange {
    public int[] smallestRange(int[][] nums) {
        PriorityQueue<Element> pq = new PriorityQueue<Element>((a, b) -> a.val - b.val);
        int curMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            Element e = new Element(i, 0, nums[i][0]);
            pq.offer(e);
            curMax = Math.max(curMax, nums[i][0]);
        }
        int range = Integer.MAX_VALUE;
        int start = -1, end = -1;
        while (pq.size() == nums.length) {

            Element curr = pq.poll();
            if (curMax - curr.val < range) {
                range = curMax - curr.val;
                start = curr.val;
                end = curMax;
            }
            if (curr.idx + 1 < nums[curr.row].length) {
                curr.idx = curr.idx + 1;
                curr.val = nums[curr.row][curr.idx];
                pq.offer(curr);
                if (curr.val > curMax) {
                    curMax = curr.val;
                }
            }
        }

        return new int[] { start, end };
    }

    class Element {
        int val;
        int idx;
        int row;

        public Element(int r, int i, int v) {
            val = v;
            idx = i;
            row = r;
        }
    }

    public static void main(String[] args) {
        SmallestRange test = new SmallestRange();
        int[][] nums = {{4,10,15,24,26}, {0,9,12,20}, {5,18,22,30}};
        int[] ans = test.smallestRange(nums);
        System.out.println(ans[0] + ", " +ans[1]);
    }
}
