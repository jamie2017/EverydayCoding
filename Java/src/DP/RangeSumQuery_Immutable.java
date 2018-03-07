package DP;

/**
 * Created by jianmei on 6/19/16.
 */
public class RangeSumQuery_Immutable {
	int[] cum;
	public RangeSumQuery_Immutable(int[] nums) {
		cum = new int[nums.length + 1];
		cum[0] = 0;
		for (int i = 0; i < nums.length; i++) {
			cum[i + 1] = nums[i] + cum[i];
		}

	}

	public int sumRange(int i, int j) {
		return cum[j + 1] - cum[i];

	}
}
