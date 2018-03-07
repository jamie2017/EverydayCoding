package Heap;

import java.util.*;

/**
 * Created by JMYE on 9/22/16.
 */
public class SlidingWindowMaximum {

    // Priority Queue O(nlogk)
    public int[] maxSlidingWindow_heap(int[] nums, int k) {
        int len = nums.length;
        int[] result = new int[len - k + 1];
        if(nums.length == 0) return new int[0];
        Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                return Integer.compare(i2, i1);
            }
        }); // to make the number in queue is in desceding order queue.peek() is the biggest numberin queue

        for(int i = 0; i < k; i ++){
            queue.add(nums[i]);
        }
        result[0] = queue.peek();
        for(int i = k; i < len; i ++){
            queue.remove(nums[i - k]);
            queue.add(nums[i]);
            result[i - k + 1] = queue.peek();
        }

        return result;
    }

    // O(n)
    // for deque A<-B<-C<-D<-E
    // poll() : poll the first left B<-C<-D<-E
    // peek(): the first left element B
    // peekLast(): the first right element E
    public int[] maxSlidingWindow_DQ(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();// dq store the index of nums, thus if the peek() index is < i - k + 1
                // then it will need to remove from dq
                // to poll the head of deque is out of [i - k + 1, i]range
            }
            System.out.println(">>>>>" + i+": " + nums[i]);
            System.out.println(dq);
            System.out.println(nums[dq.peek()]);
            System.out.println(nums[dq.peekLast()]);
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            } // this loop is make the deque is in descending order

            dq.offer(i);
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[dq.peek()];
            }
        }
        return result;
    }
    public static void main(String[] argu) {
        SlidingWindowMaximum test = new SlidingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(test.maxSlidingWindow_DQ(nums,k));
    }

}
