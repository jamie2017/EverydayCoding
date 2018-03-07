package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianmei on 6/29/16.
 */
public class PalindromePermutationII {
	/*
	apply palindrome permuation that check and generate input array for permuation
	for example s = 'aabbc'
	then ->> nums = ['a','b'], getPermutation(nums) as first half
	 */
	public List<String> generatePalindromes(String s) {
		List<String> rst = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return rst;
		}
		int[] map  = new int[256];
		for (int i = 0; i < s.length(); i++) {
			map[s.charAt(i)]++;
		}
		int j = 0, count = 0;
		for (int i = 0; i < 256; i++) {
			if (count == 0 && map[i] % 2 == 1) {
				j = i; // find the odd letter
				count++;
			} else if (map[i] % 2 == 1) {
				// if true, mean there're a least two odd counts,
				// >> no exits valid palindromes, thus return []
				return rst;
			}
		}
		String cur = "";
		if (j != 0) {
			cur = "" + (char)j;
			map[j]--;
		}
		getPermutation(rst,cur,map,s.length());
		return rst;

	}
	public void getPermutation(List<String> rst, String cur, int[] map, int len) {
			if (cur.length() == len) {
				rst.add(new String(cur));// rst.add(cur) is ok
				return;
		} else {
			for (int i = 0; i < map.length; i++) {
				if (map[i] <= 0) continue;
				map[i] = map[i] - 2;
				cur = (char) i + cur + (char) i;
				getPermutation(rst,cur,map,len);
				cur = cur.substring(1,cur.length() - 1);
				map[i] = map[i] + 2;
			}
		}

	}
	
}
