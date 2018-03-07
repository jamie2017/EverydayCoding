package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jianmei on 6/17/16.
 */
public class Subsets {
	public List<List<Integer>> subsets_recursive(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums);
		subsetsHelper(result, list, nums, 0);

		return result;
	}

	private void subsetsHelper(List<List<Integer>> result, List<Integer> list,
	                           int[] num, int pos) {
		result.add(new ArrayList<Integer>(list));

		for (int i = pos; i < num.length; i++) {
			list.add(num[i]);
			subsetsHelper(result, list, num, i + 1);
			list.remove(list.size() -1);
		}
//		for (int r = 0; r < result.size(); r++) {
//			System.out.println(result.get(r));
//		}
//
//		System.out.println("-----------------");

	}



	public List<List<Integer>> subsets (int[] nums) { // non-recursive
		if (nums == null)
			return null;
		Arrays.sort(nums);

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		for (int i = 0; i < nums.length; i++) {
			List<List<Integer>> temp = new ArrayList<List<Integer>>();
			for (List<Integer> a : result) {
				temp.add(new ArrayList<Integer> (a));
			}
			for (List<Integer> a : temp) {
				a.add(nums[i]);
			}
			ArrayList<Integer> single = new ArrayList<Integer>();
			single.add(nums[i]);
			temp.add(single);

			result.addAll(temp);
			for (int r = 0; r < result.size(); r++) {
				System.out.println(result.get(r));
			}

			System.out.println("-----------------");
		}

		result.add(new ArrayList<Integer>());

		return result;
	}

	public static void main (String[] argu) {
		int[] nums = {1,2,3,4};
		Subsets test = new Subsets();
		List<List<Integer>> res = test.subsets(nums);

	}
}
