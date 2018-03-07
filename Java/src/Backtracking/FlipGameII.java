package Backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JMYE on 9/15/16.
 */
public class FlipGameII {
    public boolean canWin(String s) { //O(n!!)
        if (s == null || s.length() < 2) {
            return  false;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.startsWith("++",i)) {
                String t = s.substring(0,i) + "--" + s.substring(i+2);
                if (!canWin(t)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean canWin_memo(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }

        Set<String> winSet = new HashSet<String>();
        return canWin(s,winSet);
    }
    private boolean canWin(String s, Set<String> winSet) {
        if (winSet.contains(s)) return true;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.startsWith("++",i)) {
                String t = s.substring(0,i) + "--" + s.substring(i+2);
                if (!canWin(t,winSet)) {
                    winSet.add(s);
                    return true;
                }
            }
        }
        return false;
    }
}
