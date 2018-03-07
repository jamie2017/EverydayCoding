package ByComs.Amazon.OnlineAssessment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by JMYE on 10/9/16.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++ ) {
            Integer position = map.get(target - nums[i]);
            if (position == null) {
                map.put(nums[i],i);
            } else {
                return new int[]{position,i};
            }
        }
        return null;
    }

    public static int count1_dup(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int cnt = 0;
        Set<Integer> hash = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            hash.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (hash.contains(target - nums[i])) {
                cnt++;
            }
        }
        return cnt;
    }

    public static int count2_noDup(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                if (i != map.get(target - nums[i])) {
                    cnt++;
                    map.remove(nums[i]);
                    map.remove(target - nums[i]);
                }
            }
        }
        return cnt;
    }
}
