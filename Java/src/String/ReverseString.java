package String;

import java.util.Scanner;

/**
 * Created by jianmei on 6/14/16.
 */
public class ReverseString {
	public String reverseString(String s) {
		// By API
		StringBuilder str = new StringBuilder(s);
		return str.reverse().toString();
//		if (s == null) return null;
//		if (s.equals("")) return  s;
//		char[] arrChar = s.toCharArray();
//		for (int i = 0, j = arrChar.length -1; i <= j; i++, j--) {
//			char tmp = arrChar[j];
//			arrChar[j] = arrChar[i];
//			arrChar[i] = tmp;
//		}
//
//		return new String(arrChar);


	}

	public String reverseWords1(String s) {
		Scanner parts = new Scanner(s);

		String result = "";

		while(parts.hasNext()){
			result = parts.next() + " " + result;
		}

		return result.trim();
	}

	public String reverseWords(String s) {
		if (s == null) return null;

		char[] a = s.toCharArray();
		int n = a.length;

		// step 1. reverse the whole string
		reverse(a, 0, n - 1);
		// step 2. reverse each word
		reverseWords(a, n);
		// step 3. clean up spaces
		return cleanSpaces(a, n);
	}

	void reverseWords(char[] a, int n) {
		int i = 0, j = 0;

		while (i < n) {
			while (i < j || i < n && a[i] == ' ') i++; // skip spaces
			while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
			reverse(a, i, j - 1);                      // reverse the word
		}
	}

	// trim leading, trailing and multiple spaces
	String cleanSpaces(char[] a, int n) {
		int i = 0, j = 0;

		while (j < n) {
			while (j < n && a[j] == ' ') j++;             // skip spaces
			while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
			while (j < n && a[j] == ' ') j++;             // skip spaces
			if (j < n) a[i++] = ' ';                      // keep only one space
		}

		return new String(a).substring(0, i);
	}

	// reverse a[] from a[i] to a[j]
	private void reverse(char[] a, int i, int j) {
		while (i < j) {
			char t = a[i];
			a[i++] = a[j];
			a[j--] = t;
		}
	}

}
