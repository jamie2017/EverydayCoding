package ByComs.Amazon.OnlineAssessment;

import java.util.*;

/**
 * Created by JMYE on 9/19/16.
 */
public class Amazon { //  45
    // Valid Parentheses
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if ("({[".indexOf(s.charAt(i)) >= 0) {
                stack.push(s.charAt(i));
            }else if ("]})".indexOf(s.charAt(i)) >= 0) {
                if (stack.isEmpty()) {
                    return false;
                }
                char poll = stack.peek();
                if (isPair(poll, s.charAt(i))) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                continue;
            }
        }

        return stack.size() == 0;
    }

    private boolean isPair(char a, char b) {

        if ("({[".indexOf(a) >=0 && ")}]".indexOf(b) >=0 && "({[".indexOf(a) == ")}]".indexOf(b)) {
            return true;
        }
        return false;
    }

    // Valid Anagram
    public class ValidAnagram {
        public boolean isAnagram(String s, String t) { // hash
            if (s.length() != t.length()) return false;
            Map<Character,Integer> map = new HashMap<>();
            char[] s_char = s.toCharArray();
            for(char sc: s_char){
                if(map.containsKey(sc)) {
                    map.put(sc,map.get(sc)+1);
                } else {
                    map.put(sc,1);
                }
            }
            char[] t_char = t.toCharArray();
            for(char tc: t_char){
                if (map.containsKey(tc)){
                    map.put(tc,map.get(tc) - 1);
                    if (map.get(tc) < 0) {
                        return false;
                    }
                } else{
                    return false;
                }
            }
            return true;
        }

        public boolean isAnagram2(String s, String t) {
            if(s.length() != t.length()) return false;
            int [] a = new int [26];
            for(Character c : s.toCharArray()) a[c - 'a']++;
            for(Character c : t.toCharArray()) {
                if(a[c -'a'] == 0) return false;
                a[c - 'a']--;
            }
            return true;
        }
        // Solution2 :sort
        public boolean isAnagram_sort(String s, String t)
        {
            if(null == s)
                return (t==null);
            if(t==null || s.length() != t.length())
                return false;
            char[] sChar = s.toCharArray();
            char[] tChar = t.toCharArray();

            Arrays.sort(sChar);
            Arrays.sort(tChar);

            return Arrays.equals(sChar, tChar);
            //  Arrays.equals() compare content
            //  sChar.equals(tChar) compare objects reference
            // if use sChar.equals(tChar) will wrong for case s = "", t = "", because they're 2 objects
        }

    }


    // Word Ladder two end BFS, find the length of shortest transformation sequence
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        int len = 1;
        Set<String> visited = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmpset  = beginSet;
                beginSet = endSet;
                endSet = tmpset;
            }

            Set<String> tmp = new HashSet<>();
            for (String word: beginSet) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    char old = chs[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chs[i] = c;
                        String candidate = String.valueOf(chs);

                        if (endSet.contains(candidate)) {
                            return len + 1;
                        }

                        if (!visited.contains(candidate) && wordList.contains(candidate)) {
                            tmp.add(candidate);
                            visited.add(candidate);
                        }
                    }
                    chs[i] = old;
                }
            }
            beginSet = tmp;
            len++;
        }
        return 0;
    }


    // Word Ladder II
    public class WordLadderII {
        public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
            Set<String> beginSet = new HashSet<>();
            Set<String> endSet = new HashSet<>();

            beginSet.add(beginWord);
            endSet.add(endWord);

            Map<String, List<String>> map = new HashMap<String, List<String>>();

            buildMap(wordList, beginSet, endSet, map, false);

            List<List<String>> rst = new ArrayList<List<String>>();
            List<String> path = new ArrayList<String>(Arrays.asList(beginWord));
            generateLadders(rst,map,beginWord,endWord,path);
            return rst;
        }

        private boolean buildMap(Set<String> wordList, Set<String> beginSet, Set<String> endSet, Map<String, List<String>> map, boolean flip) {
            if (beginSet.isEmpty()) {
                return false;
            }

            if (beginSet.size() > endSet.size()) {
                return buildMap(wordList, endSet, beginSet, map, !flip);
            }

            wordList.removeAll(beginSet);
            wordList.removeAll(endSet);

            boolean visited = false;
            Set<String> nextSet = new HashSet<>();

            for (String word: beginSet) {
                char[] chs = word.toCharArray();
                for(int i = 0; i < chs.length; i++) {
                    char old = chs[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chs[i] = c;
                        String candidate = String.valueOf(chs);

                        String key = flip? candidate: word;
                        String val = flip? word:candidate;
                        List<String> list = map.containsKey(key)? map.get(key) : new ArrayList<>();

                        if (endSet.contains(candidate)) {
                            if (!list.contains(val)) {
                                list.add(val);
                            }
                            map.put(key, list);
                            visited = true;
                        }

                        if (!visited && wordList.contains(candidate)) {
                            nextSet.add(candidate);
                            if (!list.contains(val)) {
                                list.add(val);
                            }
                            map.put(key,list);
                        }
                    }
                    chs[i] = old;
                }
            }
            return visited || buildMap(wordList,endSet, nextSet, map, !flip);
        }
        private void generateLadders(List<List<String>> rst,Map<String, List<String>> map, String beginWord,String endWord,List<String> path) {

            if (beginWord.equals(endWord)) {
                rst.add(new ArrayList<String>(path));
                return;
            }

            if (!map.containsKey(beginWord)) {
                return;
            }
            for (String word: map.get(beginWord)) {
                path.add(word);
                generateLadders(rst,map,word, endWord,path);
                path.remove(path.size() - 1);
            }
        }

    }




}
