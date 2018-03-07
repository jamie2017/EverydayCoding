package Array;

import java.util.*;

/**
 * Created by jianmei on 7/27/16.
 */
public class ArraySolution {
    // Range addition  MARK!!
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        for (int i = 0; i < updates.length; i++) {
            int start = updates[i][0], end = updates[i][1];
            int inc = updates[i][2];
            result[start] += inc;
            if (end < length - 1) {
                result[end + 1] -= inc;
            }
        }

        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += result[i];
            result[i] = sum;
        }
        return result;
    }
    // 217.Contains Duplicate
    public boolean containsDuplicate(int[] nums) {
        //// Too young to naive O(n) O(n)
        // HashMap hm = new HashMap();
        // for (int i = 0; i < nums.length; i++) {
        // 	if (hm.containsKey(nums[i]) == true) {
        // 		return true;
        // 	} else {
        // 		hm.put(nums[i],i);
        // 	}
        // }
        //    return false;

        //// Better one O(n) O(1)
        // if (nums.length == 1) return false;
        // Set<Integer> hashSet = new HashSet();
        // for (int n : nums) {
        // 	if (! hashSet.add(n)) { // If there is already has same element in set, add will return false
        // 		return true;
        // 	}
        // }
        // return false;

        //// Sort it O(nlogn) O(1)
        if (nums.length == 1) return  false;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }


    // 219. Contains Duplicate II
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }

    // 220. Contains Duplicate III
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
}
