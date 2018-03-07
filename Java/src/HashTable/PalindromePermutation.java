package HashTable;

import java.util.BitSet;
import java.util.HashMap;

/**
 * Created by jianmei on 6/29/16.
 */
public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
		/*
		if s.length() is even, then all  char should be even
		if s.length() is odd, then has and only has one odd char
		 */
		if (s == null || s.length() == 0) {
			return false;
		}

		int[] chars = new int[128];
		for (char c : s.toCharArray()) {
			chars[(int) c]++;
		}

		int count = 0;
		for (int i : chars) {
			count += i % 2;
		}
		return count <= 1;
	}
}
