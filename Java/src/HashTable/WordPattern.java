package HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.lang.String;
import java.util.Objects;


// 290. Word Pattern
/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
*/
public class WordPattern {
	// one hashmap to ensure key is unique
	// one hashset to ensure value is also unique
	public boolean wordPattern(String pattern, String str) {
		if (pattern == null && str == null) {
			return true;
		}
		if (pattern == null || str == null) {
			return false;
		}

		char[] p_list = pattern.toCharArray();
		String[] str_list = str.split(" ");
		if (p_list.length != str_list.length) {
			return false;
		}

		HashMap<Character,String> map = new HashMap<>();
		HashSet<String> strSet = new HashSet<>();

		for (int i = 0; i < p_list.length; i++) {
			if (map.containsKey(p_list[i]) && map.get(p_list[i]).equals(str_list[i])) {
				continue;
			} else if (!map.containsKey(p_list[i]) && !strSet.contains(str_list[i])) {
				map.put(p_list[i],str_list[i]);
				strSet.add(str_list[i]);
			} else {
				return false;
			}
		}
		return true;

	}



	public static void main(String[] argus) {
		WordPattern test = new WordPattern();
		System.out.println(test.wordPattern("abba","dog cat cat dog"));
		System.out.println(test.wordPattern("abba","dog cat cat fish"));
		System.out.println(test.wordPattern("aaaa","dog cat cat dog"));
		System.out.println(test.wordPattern("abba","dog dog dog dog"));
	}
}


