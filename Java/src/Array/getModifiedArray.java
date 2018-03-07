package Array;

/**
 * Created by jianmei on 7/10/16.
 */
public class getModifiedArray {
	public int[] getModifiedArray(int length, int[][] updates) {
		int[] modified = new int[length];
		for (int[] update : updates) {
			modified[update[1]] += update[2];
			if (update[0] > 0) modified[update[0] - 1] -= update[2];
		}
		for (int i = length - 2; i >= 0; i--) {
			modified[i] = modified[i + 1] + modified[i];
		}
		return modified;
	}
}
