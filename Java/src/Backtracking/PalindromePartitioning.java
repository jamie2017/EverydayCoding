package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 9/15/16.
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> rst = new ArrayList<List<String>>();
        dfs(s, 0, new ArrayList<String>(), rst);
        return rst;
    }

    private void dfs(String s, int position, List<String> list, List<List<String>> rst) {
        if (position == s.length()) {
            rst.add(new ArrayList<>(list));
        } else {
            for (int i = position; i < s.length(); i++) {
                if(isPalindrome(s,position,i)) {
                    list.add(s.substring(position,i+1));
                    System.out.println("i: "+ i + " "+list);
                    dfs(s,i + 1, list, rst);
                    list.remove(list.size() - 1);
                }
            }

        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low ++) != s.charAt(high --)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s= "aab";
        PalindromePartitioning pp = new PalindromePartitioning();
        System.out.println(pp.partition(s));

    }
}
