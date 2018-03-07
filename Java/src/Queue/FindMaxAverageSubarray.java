package Queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 7/16/17.
 */
public class FindMaxAverageSubarray {
    public double findMaxAverage(int[] nums, int k) { // O(n)
        if (nums.length == 1) {
            return (double)nums[0];
        }
        double maxAvg = Double.MIN_VALUE;
        int[] cumSum = getCumSum(nums);
        List<Integer> deque = new ArrayList<>();
        for (int j = k - 1; j < nums.length; j++) {
            while (deque.size() >= 2
                    && (avgRange(cumSum,deque.get(deque.size() - 2),deque.get(deque.size() - 1) - 1)
                    >= avgRange(cumSum,deque.get(deque.size() - 2),j - k))){
                deque.remove(deque.size() - 1);
            }
            deque.add(j - k + 1);
            while (deque.size() >= 2 && avgRange(cumSum,deque.get(0), deque.get(1) - 1) <= avgRange(cumSum,deque.get(0),j)){
                deque.remove(0);
            }
            maxAvg = Math.max(maxAvg, avgRange(cumSum, deque.get(0),j));
        }
        return maxAvg;



    }
    private double avgRange(int[] cumSum,int i, int j) {
        return (double)(cumSum[j + 1] - cumSum[i])/(j + 1 - i);
    }
    private int[] getCumSum(int[] nums) {
        int[] cumSum = new int[nums.length + 1];
        cumSum[0] = 0;
        for (int i = 0; i < nums.length; i++){
            cumSum[i + 1] = cumSum[i] + nums[i];
        }
        return cumSum;
    }


    public static void main(String[] args) {
        FindMaxAverageSubarray test = new FindMaxAverageSubarray();
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(test.findMaxAverage(nums,k));
    }
}


