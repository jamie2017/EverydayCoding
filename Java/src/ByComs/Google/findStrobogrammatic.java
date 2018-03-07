package ByComs.Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jianmei on 7/4/16.
 */
public class findStrobogrammatic { // 247. Strobogrammatic Number II
	public List<String> findStrobogrammatic(int n) {
		return helper(n,n);
	}
	private List<String> helper(int n, int max) {
		if (n == 0) return new ArrayList<>(Arrays.asList(""));
		if (n == 1) return new ArrayList<>(Arrays.asList("0","1","8"));

		List<String> list = helper(n - 2, max);
		List<String> res = new ArrayList<String>();

		for (String s: list) {
			if (n != max) res.add("0" + s + "0"); // because we don't need numbers like "0000","0110"
			res.add("1" + s + "1");
			res.add("6" + s + "9");
			res.add("8" + s + "8");
			res.add("9" + s + "6");
		}
		return  res;
	}

	public static void main(String[] argu) {
		findStrobogrammatic test = new findStrobogrammatic();
		System.out.println(test.findStrobogrammatic(8));

	}
}
