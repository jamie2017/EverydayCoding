package BFS;

import java.util.*;

/**
 * Created by JMYE on 9/20/16.
 */
public class WordLadder {
    // two end BFS, think of finding shortest path
    // use two end because if beginWord can be transfer to endWord,
    // then endWord can also transfer to beginWord
    // use two sets to implement two end BFS
    // use visited to record visited words

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int len = 1;
        Set<String> visited = new HashSet<>();
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmpSet = beginSet;
                beginSet = endSet;
                endSet = tmpSet;
            }
            System.out.println("BeginSet " + beginSet.toString() + " " + "EndSet " + endSet.toString());

            Set<String> nextLevel = new HashSet<>();
            for (String word: beginSet) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    char prev = chs[i];
                    for(char c = 'a'; c < 'z'; c++) {
                        chs[i] = c;
                        String newWord = String.valueOf(chs);

                        if (endSet.contains(newWord)) {
                            return len + 1;
                        }

                        if (!visited.contains(newWord) && wordList.contains(newWord)) {
                            visited.add(newWord);
                            nextLevel.add(newWord);
                        }
                    }
                    chs[i] = prev;
                }
            }
            beginSet = nextLevel;
            len++;
        }
        return 0;
    }



    public static void main(String[] args) {
        WordLadder test = new WordLadder();
        List<String> wList = new ArrayList<>(Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        String bWord = "hit";
        String eWord = "cog";
        System.out.println(test.ladderLength(bWord,eWord,wList));

    }
}
