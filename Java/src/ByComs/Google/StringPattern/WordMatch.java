package ByComs.Google.StringPattern;

import java.util.*;

/**
 * Created by JMYE on 7/27/17.
 */
public class WordMatch {
    public boolean wordMatch(String word1, String word2) {
        if (word1 == null && word2 == null) return true;
        if (word1 == null || word2 == null) return false;
        if (word1.length() != word2.length()) return false;
        Map<Character,Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < word1.length();i++) {
            if (map.containsKey(word1.charAt(i)) && map.get(word1.charAt(i)) == word2.charAt(i)) {
                continue;
            } else if (!map.containsKey(word1.charAt(i)) && !set.contains(word2.charAt(i))) {
                map.put(word1.charAt(i),word2.charAt(i));
                set.add(word2.charAt(i));
            } else {
                return false;
            }
        }
        return true;
    }

    public List<String> wordMatchFollowUp(String[] words, String checkWord) {
        Map<String, List<String>> wordsMap = new HashMap<>();
        boolean[] used = new boolean[words.length];
        for (int i = 0;i < words.length; i++) {
            if (used[i]) continue;
            String key = words[i];
            wordsMap.put(key, new ArrayList<>());
            wordsMap.get(key).add(key);
            used[i] = true;
            for (int j = i + 1; j < words.length; j++) {
                if (used[j]) continue;
                String val = words[j];
                if (wordMatch(key,val)) {
                    wordsMap.get(key).add(val);
                    used[j] = true;
                }
            }
        }
//        System.out.println(wordsMap);
        for (String key: wordsMap.keySet()) {
            if (wordMatch(key, checkWord)) {
                return wordsMap.get(key);
            }
        }
        return new ArrayList<>();
    }



    public static void main(String[] args) {
        WordMatch test = new WordMatch();
        System.out.println(test.wordMatch("banana","cololo")); // true
        System.out.println(test.wordMatch("banana","abcbcb")); // true
        System.out.println(test.wordMatch("banana","ololol")); // false
        System.out.println(test.wordMatch("banana","efifif")); // true
        System.out.println(test.wordMatch("banana","leiele")); // false

        String[] words = {"banana","cololo","abcbcb","ololol","efifif","leiele"};
        String checkWord = "jamama";
        System.out.println(test.wordMatchFollowUp(words,checkWord));
        checkWord = "mamama";
        System.out.println(test.wordMatchFollowUp(words,checkWord));
        checkWord = "majama";
        System.out.println(test.wordMatchFollowUp(words,checkWord));
        checkWord = "jamiey";
        System.out.println(test.wordMatchFollowUp(words,checkWord));
    }
}
