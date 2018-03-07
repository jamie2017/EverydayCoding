package String;

/**
 * Created by jianmei on 6/14/16.
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if (s == "") return true;
		if (s == null) return  true;
		s = s.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(s);
		char[] s_array = s.toCharArray();
		int start = 0;
		int end = s_array.length - 1;
		while (start < end) {
			if (Character.toLowerCase(s_array[start]) != Character.toLowerCase(s_array[end])) {
				return false;
			}
			start ++;
			end --;
		}

		return true;
	}

	public static void main (String[] argu) {
		ValidPalindrome test = new ValidPalindrome();
		String s = "A man, a plan, a canal: Panama";
		System.out.println(test.isPalindrome(s));
	}
}
