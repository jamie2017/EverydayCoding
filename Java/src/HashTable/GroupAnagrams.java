package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jianmei on 6/29/16.
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		HashMap<String,List<String>> map = new HashMap<>();
		for(String str: strs) {
			char[] tmp = str.toCharArray();
			Arrays.sort(tmp);
			String key = String.valueOf(tmp);
			if (map.containsKey(key)) {
				map.get(key).add(str);
			} else {
				List<String> list = new ArrayList<> ();
				list.add(str);
				map.put(key, list);
			}
		}

		for(List<String> list : map.values()){
			res.add(list);
		}
		return res;
	}
    public static void main(String[] argu) {
	    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
	    GroupAnagrams test = new GroupAnagrams();
	    List<List<String>> res = test.groupAnagrams(strs);
	    for(List<String> list: res) {
		    System.out.println(list);
	    }
    }

}
