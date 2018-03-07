package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianmei on 6/15/16.
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
	public int[] twoSumOpim(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	public static void main (String[] argu) {
		TwoSum test = new TwoSum();
		int[] nums = {99,4,3,1};
		int target = 100;
		int[] res = test.twoSum(nums,target);
		for (int n : res) {
			System.out.println(n);
		}
	}
}
