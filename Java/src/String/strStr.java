package String;

/**
 * Created by jianmei on 6/21/16.
 */
public class strStr {
	public int strStr(String source, String target) {
		if (source == null || target == null) {
			return -1;
		}

		for (int i = 0; i < source.length() - target.length() + 1; i++) {
			int j = 0;
			for (j = 0; j < target.length(); j++) {
				if (source.charAt(i + j) != target.charAt(j)) {
					break;
				}
			}
			// finished loop, target found
			if (j == target.length()) {
				return i;
			}
		}
		return -1;
	}

	public static void main (String[] argu) {
		String haystack = "Today is a good day.";
		String needle = "day";
//		String haystack = "aaa";
//		String needle = "aa";
//		String haystack = "mississippi"
//		String needle = "a";
		strStr test = new strStr();
		System.out.println(test.strStr(haystack,needle));
	}
}
