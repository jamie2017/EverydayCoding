package String;

/**
 * Created by jianmei on 6/14/16.
 */
public class ReverseVowelsofString {
	public String reverseVowels(String s) {
		if (s == null || s.equals("")) return s;

		char[] sChar = s.toCharArray();
		int i = 0, j = s.length() - 1;
		while (i <= j) {
			if (isVowels(sChar[i]) && isVowels(sChar[j])) {
				char tmp = sChar[i];
				sChar[i++] = sChar[j];
				sChar[j--] = tmp;
			} else if (isVowels(sChar[i])) {
				j--;
			} else if (isVowels(sChar[j])) {
				i++;
			} else {
				i++;
				j--;
			}
		}
		return new String(sChar);
	}

	private boolean isVowels(Character c) {
		String vowerls = "aeiouAEIOU";
		return vowerls.indexOf(c) >= 0;
	}
}
