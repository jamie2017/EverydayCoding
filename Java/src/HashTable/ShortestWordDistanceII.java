package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jianmei on 6/22/16.
 * Modified by Jianmei on 7/31/17
 */
public class ShortestWordDistanceII {
	Map<String, List<Integer>> wordMap;
	public ShortestWordDistanceII(String[] words) {
		wordMap = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			if (!wordMap.containsKey(word)) {
				wordMap.put(word, new ArrayList<>());
			}
			wordMap.get(word).add(i);
		}
	}
	public int shortest(String word1, String word2) {
		List<Integer> L1 = wordMap.get(word1);
		List<Integer> L2 = wordMap.get(word2);
		int i = 0, j = 0;
		int minDist = Integer.MAX_VALUE;
		while (i < L1.size() && j < L2.size()) {
			minDist = Math.min(minDist, Math.abs(L1.get(i) - L2.get(j)));
			if (L1.get(i) > L2.get(j)) {
				j++;
			} else {
				i++;
			}
		}
		return minDist;
	}
}
