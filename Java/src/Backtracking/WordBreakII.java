package Backtracking;

import java.util.*;

/**
 * Created by JMYE on 9/15/16.
 */
public class WordBreakII {
    Map<String, List<String>> map = new HashMap<String, List<String>>();
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> rst = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return rst;
        }

        if (map.containsKey(s)) {
            return map.get(s);
        }

        if (wordDict.contains(s)) {
            rst.add(s);
        }

        for (int i = 1; i < s.length(); i++) {
            String t = s.substring(i);
            if (wordDict.contains(t)) {
                List<String> tmp = wordBreak(s.substring(0,i), wordDict);
                if (tmp.size() != 0) {
                    for (int j = 0; j < tmp.size(); j++) {
                        rst.add(tmp.get(j) + " " + t);
                    }
                }
            }
        }
        map.put(s,rst);
        return rst;
    }
}
