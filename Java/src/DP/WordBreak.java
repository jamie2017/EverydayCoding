package DP;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JMYE on 9/17/16.
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] f = new boolean[s.length() + 1];
        // f[i] = true meaning split at i,
        f[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i;j++) {
                // note: condition here it f[j] &&
                if (f[j] && dict.contains(s.substring(j,i))){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }

    // better one
    public boolean wordBreak_opt(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0){
            return true;
        }
        int n = s.length();
        boolean [] dp = new boolean[n+1];
        dp[0] = true ;

        int maxLength = 0;
        for(String t : wordDict){
            maxLength = Math.max(maxLength, t.length());
        }

        for(int i = 1; i <= n; i++){
            dp[i] = false;
            for(int j = i-1; j >= Math.max(0, i - maxLength) && !dp[i]; j--){
                if(dp[j]){
                    if(wordDict.contains(s.substring(j, i))){
                        dp[i] = true;
                    }
                }
            }

        }

        return dp[n];


    }

    // Trie
    public class TrieNode {
        boolean isWord;
        TrieNode[] c;

        public TrieNode(){
            isWord = false;
            c = new TrieNode[128];
        }
    }

    public void addWord(TrieNode t, String w) {
        for (int i = 0; i < w.length(); i++) {
            int j = (int)w.charAt(i);
            if (t.c[j] == null) t.c[j] = new TrieNode();
            t = t.c[j];
        }
        t.isWord = true;
    }

    public boolean wordBreak_trie(String s, Set<String> wordDict) {
        TrieNode t = new TrieNode(), cur;
        for (String i : wordDict) addWord(t, i);
        char[] str = s.toCharArray();
        int len = str.length;
        boolean[] f = new boolean[len + 1];
        f[len] = true;

        for (int i = len - 1; i >= 0; i--) {
            //System.out.println(str[i]);
            cur = t;
            for (int j = i; cur != null && j < len ; j++) {
                cur = cur.c[(int)str[j]];
                if (cur != null && cur.isWord && f[j + 1]) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[0];
    }


    public boolean wordBreak_dfs(String s, Set<String> dict) {
        // DFS
        Set<Integer> set = new HashSet<Integer>();
        return dfs(s, 0, dict, set);
    }

    private boolean dfs(String s, int index, Set<String> dict, Set<Integer> set){
        // base case
        if(index == s.length()) return true;
        // check memory
        if(set.contains(index)) return false;
        // recursion
        for(int i = index+1;i <= s.length();i++){
            String t = s.substring(index, i);
            if(dict.contains(t))
                if(dfs(s, i, dict, set))
                    return true;
                else
                    set.add(i);
        }
        set.add(index);
        return false;
    }
    public static void main (String[] args) {
        String s = "leetcodeleet";
        Set<String> dict = new HashSet<>();
        dict.add("leet");
        dict.add("co");
        dict.add("de");
        dict.add("other");
        WordBreak test = new WordBreak();
        System.out.println(test.wordBreak_dfs(s,dict));
    }
}
