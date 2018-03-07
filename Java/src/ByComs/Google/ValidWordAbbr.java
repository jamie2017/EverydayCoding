package ByComs.Google;

import java.util.HashMap;

/**
 * Created by jianmei on 7/2/16.
 */
public class ValidWordAbbr {
	HashMap<String ,String> map;

	public ValidWordAbbr(String[] dictionary) {
		map = new HashMap<>();
		for (String str: dictionary) {
			String key = getKey(str);
			if(map.containsKey(key)){
				if(!map.get(key).equals(str)){
					map.put(key,"");
				}
			} else {
				map.put(key,str);
			}
		}

	}

	public boolean isUnique(String word) {
        return !map.containsKey(getKey(word)) || map.get(getKey(word)).equals(word);
	}

	private String getKey(String str) {
		if (str.length() <= 2) return str;
		return str.charAt(0) + Integer.toString(str.length() - 2) + str.charAt(str.length() - 1);
	}
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");