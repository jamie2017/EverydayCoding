package ByComs.Google;

/**
 * Created by jianmei on 7/2/16.
 */
public class IsStrobogrammatic {
	public boolean isStrobogrammatic1(String num) {
		for (int i = 0, j = num.length() - 1; i <= j; i++, j--) {
			if (!"11 88 696 00".contains(num.charAt(i)+""+num.charAt(j))){
				return false;
			}
		}
		return true;
	}
}
