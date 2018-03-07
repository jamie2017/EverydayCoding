package HashTable;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by jianmei on 6/29/16.
 */
public class ValidAnagram {
	public boolean isAnagram(String s, String t) { // hash
		if (s.length() != t.length()) return false;
		HashMap<Character,Integer> map = new HashMap<>();
		char[] s_char = s.toCharArray();
		for(char sc: s_char){
			if(map.containsKey(sc)) {
				map.put(sc,map.get(sc)+1);
			} else {
				map.put(sc,1);
			}
		}
		char[] t_char = t.toCharArray();
		for(char tc: t_char){
			if (map.containsKey(tc)){
				map.put(tc,map.get(tc) - 1);
				if (map.get(tc) < 0) {
					return false;
				}
			} else{
				return false;
			}
		}
		return true;
	}

	public boolean isAnagram2(String s, String t) {
		if(s.length() != t.length()) return false;
		int [] a = new int [26];
		for(Character c : s.toCharArray()) a[c - 'a']++;
		for(Character c : t.toCharArray()) {
			if(a[c -'a'] == 0) return false;
			a[c - 'a']--;
		}
		return true;
	}
	// Solution2 :sort
	public boolean isAnagram_sort(String s, String t)
	{
		if(null == s)
			return (t==null);
		if(t==null || s.length() != t.length())
			return false;
		char[] sChar = s.toCharArray();
		char[] tChar = t.toCharArray();

		Arrays.sort(sChar);
		Arrays.sort(tChar);

		return Arrays.equals(sChar, tChar);
	}

}
