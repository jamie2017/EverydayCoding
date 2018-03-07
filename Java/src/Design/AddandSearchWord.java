package Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JMYE on 9/15/16.
 */
public class AddandSearchWord {
    Map<Integer, List<String>> map = new HashMap<>();

    // Adds a word into the data structure.
    public void addWord(String word) {
        int index = word.length();
        if (!map.containsKey(index)) {
            List<String> list = new ArrayList<>();
            list.add(word);
            map.put(index,list);
        } else {
            map.get(index).add(word);
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        int index = word.length();
        if (!map.containsKey(index)) {
            return false;
        }

        List<String> list = map.get(index);
        for (String s: list) {
            if (isMatched(s, word)) {
                return true;
            }
        }
        return false;
    }

    private boolean isMatched(String s, String word) {
        for (int i = 0; i < s.length(); i++) {
            if (word.charAt(i) != '.' && s.charAt(i) != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
