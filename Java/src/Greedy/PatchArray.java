package Greedy;

/**
 * Created by JMYE on 11/17/16.
 */
public class PatchArray {
    /*
    The variable max records the maximal value that can be formed by the elements in nums and patched numbers.
    If max is less than nums[i] - 1 which means we need to patch a new number,
     we then patch max + 1.
     */
    public int minPatches(int[] nums, int n) {
        long max = 0;
        int cnt = 0;
        for (int i = 0; max < n;) {
            if (i >= nums.length || max < nums[i] - 1) {
                max += max + 1;
                cnt++;
            } else  {
                max += nums[i];
                i++;
            }
        }
        return cnt;
    }
}
