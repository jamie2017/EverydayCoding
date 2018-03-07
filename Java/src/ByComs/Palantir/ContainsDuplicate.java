package ByComs.Palantir;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JMYE on 11/1/16.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(!set.add(num)) {
                return true;
            };
        }
        return set.size() == nums.length ? false:true;

    }
}
