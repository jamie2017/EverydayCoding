package ByComs.SumoLogic;

import java.util.*;

/**
 * Created by JMYE on 6/22/17.
 * 1. 字典里有大量words，给一个query，如果在字典里能找到one edit distance则返回
 那个word。followup是如果是k edit distance呢。不能对字典里的所有word做简单的
 预处理（产生所有可能的k edit以后的词加入字典）
 */
public class KEditDistanceQuery {

    public void findKEditDistanceWord(List<String> words, String query, int k) {
        Map<Integer, List<String>> wordMap =  preprocess(words);
        List<String> targetList = narrowDownSearchSpace(wordMap,query,k);
//        System.out.println(targetList);
        doQuery(targetList,query,k);

    }
    private Map<Integer, List<String>> preprocess(List<String> words) {
        Map<Integer, List<String>> wordMap = new HashMap<>();
        for (String w: words) {
            if (!wordMap.containsKey(w.length())) {
                wordMap.put(w.length(),new ArrayList<>());
            }
            wordMap.get(w.length()).add(w);
        }
        return wordMap;
    }

    private List<String> narrowDownSearchSpace(Map<Integer, List<String>> wordMap, String query, int k) {
        List<String> targetList = new ArrayList<>();
        for (int i = query.length() - k; i < query.length() + k + 1; i++) {
            if (wordMap.containsKey(i)) {
                targetList.addAll(wordMap.get(i));
            }
        }
        return targetList;
    }

    private void doQuery(List<String> targetList, String query,int k) {
        for (String word: targetList) {
            if (minDistance(word,query) <= k) {
                System.out.println(word);
//                return;
            }
        }
//        System.out.println("No such word!");
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] cost = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            cost[i][0] = i;
        }
        for(int i = 1; i <= n; i++) {
            cost[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    cost[i][j] = cost[i - 1][j - 1];
                } else {
                    int replace = cost[i - 1][j - 1];
                    int insert = cost[i][j - 1]; // add j
                    int delete = cost[i - 1][j]; // delete
                    cost[i][j] = Math.min(replace,Math.min(insert,delete)) + 1;
                }
            }
        }
        return cost[m][n];
    }


    public List<String> getKEditDistance(String[] words, String target, int k) {
        List<String> result = new ArrayList<>();

        if (words == null || words.length == 0 ||
                target == null || target.length() == 0 ||
                k < 0) {
            return result;
        }

        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }

        TrieNode root = trie.root;

        int[] prev = new int[target.length() + 1];
        for (int i = 0; i < prev.length; i++) {
            prev[i] = i;
        }

        getKEditDistanceHelper("", target, k, root, prev, result);

        return result;
    }

    private void getKEditDistanceHelper(String curr, String target, int k, TrieNode root,
                                        int[] prevDist, List<String> result) {
        if (root.isLeaf) {
            if (prevDist[target.length()] <= k) {
                result.add(curr);
            } else {
                return;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] == null) {
                continue;
            }

            int[] currDist = new int[target.length() + 1];
            currDist[0] = curr.length() + 1;
            for (int j = 1; j < prevDist.length; j++) {
                if (target.charAt(j - 1) == (char) (i + 'a')) {
                    currDist[j] = prevDist[j - 1];
                } else {
                    currDist[j] = Math.min(Math.min(prevDist[j - 1], prevDist[j]),
                            currDist[j - 1]) + 1;
                }
            }

            getKEditDistanceHelper(curr + (char) (i + 'a'), target, k,
                    root.children[i], currDist, result);
        }
    }

    public static void main(String[] args) {
        KEditDistanceQuery test = new KEditDistanceQuery();
        List<String> words = Arrays.asList(new String[]{"hello","word","world","war","haha","hella","wow"});
        int k = 1;
        String query = "helo";
        test.findKEditDistanceWord(words,query, k);
        System.out.println(test.getKEditDistance((String[]) words.toArray(),query,k));
        k = 3;
        query = "h";
        test.findKEditDistanceWord(words,query, k);
        System.out.println();
        System.out.println(test.getKEditDistance((String[]) words.toArray(),query,k));
        System.out.println();
        words = Arrays.asList(new String[]{"abc","abd","abcd","adc"});
        k = 1;
        query = "ac";
        test.findKEditDistanceWord(words,query, k); // abc adc
        System.out.println(test.getKEditDistance((String[]) words.toArray(),query,k));

    }

}

class TrieNode {
    TrieNode[] children;
    boolean isLeaf;

    public TrieNode() {
        children = new TrieNode[26];

    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Add a word into trie
    public void add(String s) {
        if (s == null || s.length() == 0) {
            return;
        }

        TrieNode p = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (p.children[c - 'a'] == null) {
                p.children[c - 'a'] = new TrieNode();
            }

            if (i == s.length() - 1) {
                p.children[c - 'a'].isLeaf = true;
            }

            p = p.children[c - 'a'];
        }
    }
}