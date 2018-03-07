package Array;

/**
 * Created by JMYE on 11/1/16.
 */
public class ThirdMax {
    public int thirdMax(int[] nums) { // so smart
        long max = Long.MIN_VALUE, mid = max, min = max;
        for(int num : nums) {
            if (num > max) {
                min = mid;
                mid = max;
                max = num;
            } else if (max > num && num > mid) {
                min = mid;
                mid = num;
            } else if (mid > num && num > min) {
                min = num;
            }
        }
        return (int)(min != Long.MIN_VALUE ? min : max);
    }
}
