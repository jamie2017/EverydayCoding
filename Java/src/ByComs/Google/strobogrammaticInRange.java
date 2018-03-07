package ByComs.Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jianmei on 7/4/16.
 */


public class strobogrammaticInRange {
	public int strobogrammaticInRange(String low, String high){
		int count = 0;
		List<String> rst = new ArrayList<String>();
		for (int n = low.length(); n <= high.length(); n++) {
			System.out.println(helper(n,n));
			rst.addAll(helper(n,n));
		}
		for(String num : rst){
			if((num.length() == low.length() && num.compareTo(low) < 0) ||
					   (num.length() == high.length() && num.compareTo(high) > 0)) continue;
			count ++;
			System.out.println(num);
		}
		return count;
	}

	private List<String> helper(int cur, int max) {
		if (cur == 0) return new ArrayList<>(Arrays.asList(""));
		if (cur == 1) return new ArrayList<>(Arrays.asList("1","8","0"));

		List<String> rst = new ArrayList<String>();
		List<String> center = helper(cur - 2, max);
		for (String s: center) {
			if (cur != max) rst.add("0" + s + "0");
			rst.add("1" + s + "1");
			rst.add("6" + s + "9");
			rst.add("8" + s + "8");
			rst.add("9" + s + "6");
		}
		return rst;
	}

	public static void main(String[] argu) {
		strobogrammaticInRange test = new strobogrammaticInRange();
		String l = "10",h = "200";
		System.out.println(test.strobogrammaticInRange(l,h));
	}
}
