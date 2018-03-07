package Array;
import java.util.*;
/**
 * Created by jianmei on 6/6/16.
 */
public class ContainsDuplicateII { // Time limit error
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
        	if (!hm.containsKey(Integer.toString(nums[i]))) {
                hm.put(Integer.toString(nums[i]),i);
        	} else {
                if (Math.abs(hm.get(Integer.toString(nums[i])) - i) <= k) {
                     return true;
                } else {
                     hm.replace(Integer.toString(nums[i]),i);
                }
        	}
        }
        return false;
    }


    public boolean containsNearbyDuplicateII(int[] nums, int k) {
    	Set<Integer> set = new HashSet<>();
	    for (int i = 0; i < nums.length; ++i) {
	        if (set.contains(nums[i])) return true;
	        set.add(nums[i]);
	        if (set.size() > k) {
	            set.remove(nums[i - k]);
	        }
	    }
	    return false;
    }

    public static void main (String[] argu) {
    	ContainsDuplicateII test = new ContainsDuplicateII();
    	int[] nums = {1,2,3,5,2,3,1,4};
    	int k = 4;
    	System.out.println(test.containsNearbyDuplicateII(nums,k));
    }
}
