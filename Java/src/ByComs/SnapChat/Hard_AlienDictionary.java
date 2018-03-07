package ByComs.SnapChat;

import java.util.*;

/**
 * Created by JMYE on 10/22/16.
 */
public class Hard_AlienDictionary {
    public static String alienOrder(String[] words) {// Topological Sort + BFS
        if (words == null || words.length == 0) {
            return "";
        }

        int[] inDegree = new int[26];
        Map<Character, Set<Character>> outDegreeMap = new HashMap<>();
        Set<Character> dict = new HashSet<>();

        for (String word : words) {
            for (char c: word.toCharArray()) {
                dict.add(c);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int len = Math.min(w1.length(), w2.length());// word in lexicographically order meaning it is compared between words vertically
            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if (c1 != c2) {
                    Set<Character> c2Set = outDegreeMap.containsKey(c1) ? outDegreeMap.get(c1) : new HashSet<>();
                    if (!c2Set.contains(c2)) {
                        c2Set.add(c2);
                        outDegreeMap.put(c1, c2Set);
                        inDegree[c2 - 'a']++;
                    }
                    break;
                } else {
                    if(j + 1 <= w1.length() - 1 && j + 1 > w2.length() - 1) return ""; // check valid
                    // w1 = "wrtkj" w2 = "wrt" return ""
                    // w1 = "wrt" w2 = "wrtkj" return "rtwjk"
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (char c : dict) {
            if (inDegree[c - 'a'] == 0) queue.offer(c);
        }

        while (!queue.isEmpty()) {
            Character c1 = queue.poll();
            sb.append(c1);
            if (!outDegreeMap.containsKey(c1)) continue;
            for (Character c2 : outDegreeMap.get(c1)) {
                if (--inDegree[c2 - 'a'] == 0) queue.offer(c2);
            }
        }
        if (sb.length() != dict.size()) return ""; // check valid
        return sb.toString();

    }

    public static void main(String[] args) {
        String[] words = {"wrt",
                          "wrt"};

        System.out.println(alienOrder(words));
    }


}
