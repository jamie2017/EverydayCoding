package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 9/15/16.
 */
public class WordSearchII { // MARK!! GOOD!
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> rst = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length;i++) {
            for (int j = 0; j < board[0].length;j++) {
                dfs(board,i,j,root,rst);
            }
        }
        return  rst;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode r = root;
            for (char c: w.toCharArray()) {
                int i = c - 'a';
                if (r.next[i] == null) {
                    r.next[i] = new TrieNode();
                }
                r = r.next[i];
            }
            r.word = w;
        }
        return root;
    }

    public void dfs(char[][] board, int i, int j, TrieNode r, List<String> rst) {
        char c = board[i][j];
        if (c == '#' || r.next[c - 'a'] == null) return;
        r = r.next[c - 'a'];
        if (r.word != null) {
            rst.add(r.word);
            r.word = null;
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j, r, rst);
        if (j > 0) dfs(board, i, j - 1, r, rst);
        if (i < board.length - 1) dfs(board,i + 1, j, r, rst);
        if (j < board[0].length - 1) dfs(board,i, j + 1, r,rst);
        board[i][j] = c;
    }

}
