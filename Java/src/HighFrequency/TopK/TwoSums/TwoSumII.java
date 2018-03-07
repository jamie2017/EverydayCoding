package HighFrequency.TopK.TwoSums;

/**
 * Created by JMYE on 8/15/16.
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if (numbers == null || numbers.length < 2) return result;
        int left = 0,right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right --;
            } else if (numbers[left] + numbers[right] < target) {
                left ++;
            } else {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;

            }
        }
        return result;

    }
}
