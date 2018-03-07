package Array;

/**
 * Created by jianmei on 6/22/16.
 */
public class ShortestWordDistance {
	public int shortestDistance(String[] words, String word1, String word2) {
		int minDist = words.length;
		int word1Idx = -1;
		int word2Idx = -1;
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			if (word.equals(word1)) {
				word1Idx = Math.max(word1Idx, i);
			} else if (word.equals(word2)) {
				word2Idx = Math.max(word2Idx, i);
			}
			if (word1Idx != -1 && word2Idx != -1) {
				minDist = Math.min(minDist, Math.abs(word1Idx - word2Idx));
			}
		}
		return minDist;
	}
}
