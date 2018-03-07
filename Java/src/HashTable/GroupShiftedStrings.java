package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jianmei on 6/28/16.
 */
public class GroupShiftedStrings {

	/*
	Find the pattern for each group
	 */


	public List<List<String>> groupStrings(String[] strings) {
		Map<String, List<String>> map = new HashMap<> ();
		for (String str : strings) {
			String key = getKey(str);
			if (map.containsKey(key)) {
				map.get(key).add(str);
			} else {
				List<String> list = new ArrayList<> ();
				list.add(str);
				map.put(key, list);
			}
		}
		return new ArrayList<List<String>> (map.values());
	}

	private String getKey(String word) {
		StringBuilder sb = new StringBuilder();
		if (word.isEmpty())
			return sb.toString();
		char ch = word.charAt(0);
		for (int i = 0; i < word.length(); i++) {
			sb.append((char)((word.charAt(i) + 26 - ch) % 26)); // + 26  then %26 for case like [az,ba]
		}
		return sb.toString();
	}

	public static void main(String[] argus) {
		GroupShiftedStrings test = new GroupShiftedStrings();
		String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		List<List<String>> res = test.groupStrings(strings);
		for (List<String> list : res) {
			System.out.println(list);
		}

	}
}
