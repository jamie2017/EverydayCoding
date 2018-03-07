package Tries;

import java.util.HashMap;

/**
 * Created by JMYE on 11/27/16.
 */
class TrieNode {
    char c;
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean hasWord;

    public TrieNode(){}

    public TrieNode(char c) {
        this.c = c;
    }
}
public class Tries {
    private TrieNode root;

    public Tries() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        HashMap<Character, TrieNode> curChildren = root.children;
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            char wc = wordArray[i];
            if (curChildren.containsKey(wc)) {
                cur = curChildren.get(wc);
            } else {
                TrieNode newNode = new TrieNode(wc);
                curChildren.put(wc, newNode);
                cur = newNode;
            }
            curChildren = cur.children;
            if ( i == wordArray.length - 1) {
                cur.hasWord = true;
            }
        }
    }

    // Return if the word is in the trie
    public boolean search(String word) {
        if (searchWordNodePos(word) == null) {
            return false;
        } else if (searchWordNodePos(word).hasWord) {
            return true;
        } else {
            return false;
        }
    }

    public TrieNode searchWordNodePos(String s) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode cur = null;
        char[] sArray = s.toCharArray();
        for (int i = 0; i < sArray.length; i++) {
            char c = sArray[i];
            if(children.containsKey(c)) {
                cur = children.get(c);
                children = cur.children;
            } else {
                return null;
            }
        }
        return cur;
    }

    // Returns if there is any word in the trie that starts with given prefix
    public boolean startWith(String prefix) {
        if (searchWordNodePos(prefix) == null) {
            return false;
        } else {
            return true;
        }
    }


    public static void main(String[] args) {
        Tries test = new Tries();
        test.insert("something");
        test.insert("someone");
        test.insert("somewhere");
        System.out.println(test.startWith("so"));
        System.out.println(test.search("someone"));
        System.out.println(test.search("some"));

    }

}
