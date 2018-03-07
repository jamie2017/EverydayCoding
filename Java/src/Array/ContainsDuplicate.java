package Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by jianmei on 5/27/16.
 */
public class ContainsDuplicate {
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

	public static void main(String[] args) { // psvm
		System.out.println("hello world!!!");
	}
}
