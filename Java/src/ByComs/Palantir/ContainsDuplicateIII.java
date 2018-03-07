package ByComs.Palantir;

import java.util.TreeSet;

/**
 * Created by JMYE on 11/2/16.
 */
public class ContainsDuplicateIII { // O(nlgK)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        final TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {

            final Integer floor = set.floor(nums[i] + t);
            final Integer ceil = set.ceiling(nums[i] - t);
            if ((floor != null && floor >= nums[i])
                    || (ceil != null && ceil <= nums[i])) {
                return true;
            }

            set.add(nums[i]);
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }
}
