package ByComs.Amazon.OnlineAssessment;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by JMYE on 10/9/16.
 */

/*
For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position
[1 3 -1] -3 5 3 6 7
1 [3 -1 -3] 5 3 6 7
1 3 [-1 -3 5] 3 6 7
1 3 -1 [-3 5 3] 6 7
1 3 -1 -3 [5 3 6] 7
1 3 -1 -3 5 [3 6 7]
Therefore, return the max sliding window as [3,3,5,5,6,7].


 */
public class SlidingWindowMaximum {
    void dequeAdd(Deque<Integer> deque, int num) {
        while (!deque.isEmpty() && deque.peekLast() < num) {
            deque.pollLast();
        }
        deque.offerLast(num);
    }

    void dequeRemove(Deque<Integer> deque, int num) {
        if (deque.peekFirst() == num) {
            deque.pollFirst();
        }
    }

    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        if (nums.length == 0) {
            return res;
        }

        for (int i = 0; i < k - 1; ++i) {
            dequeAdd(deque, nums[i]);
        }

        for (int i = k - 1; i<nums.length; ++i) {
            dequeAdd(deque, nums[i]);
            res.add(deque.peekFirst());
            dequeRemove(deque, nums[i-k+1]);
        }

        return res;
    }
    // version 2
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return nums;

        int[] rst = new int[len - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i - k + 1 >= 0) {
                rst[i - k + 1] = nums[deque.peek()];
            }
        }
        return rst;
    }
}
