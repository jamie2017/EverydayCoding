package DFS;

import java.util.*;

/**
 * Created by JMYE on 11/30/16.
 */
public class ValidEqualCheck {
    public boolean isValid(List<String> input) {
        if (input == null || input.size() == 0) return true;
        Map<Character,List<Character>> map = new HashMap<>();

        for(String s : input) {
            char x = s.charAt(0);
            char y = s.charAt(2);
            if (s.charAt(1) == '=') {
                if(!map.containsKey(x)) {
                    map.put(x,new ArrayList<>());
                    map.get(x).add(y);
                } else {
                    map.get(x).add(y);
                }
                if(!map.containsKey(y)) {
                    map.put(y,new ArrayList<>());
                    map.get(y).add(x);
                } else {
                    map.get(y).add(x);
                }
            }
        }

        for (String s : input) {
            if (s.contains("!=")) {
                char start = s.charAt(0);
                char end = s.charAt(s.length() - 1);
                Set<Character> visited = new HashSet<>();
                if (dfs(map, start,end,visited)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(Map<Character, List<Character>> map, char start, char end, Set<Character> visited) {
        if(!visited.contains(start)) {
            visited.add(start);
            for (char c : map.get(start)) {
                char newStart = c;
                if (c == end) return true;
                if (dfs(map, newStart,end,visited)) {
                    return true;
                }
            }
        }
        return false;

    }



    public static void main(String[] args) {
        // {"a=b","c=d","b=c","a!=d"}
        List<String> input = new ArrayList<>();
        input.add("a=b");
        input.add("c=d");
        input.add("b=c");
        input.add("a!=d");
        input.add("e!=f");
        input.add("e=g");
        ValidEqualCheck test = new ValidEqualCheck();
        System.out.println(test.isValid(input));
    }
}
