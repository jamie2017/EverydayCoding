package HighFrequency.TopK.MultipleSolutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 11/28/16.
 */
public class MinimumUniqueWordAbbreviation {
    // backtracking
    int n, cand, bn, minlen, minab;
    List<Integer> dict = new ArrayList<>();


    // Abbreviation for one digit is meaningless, thus at least two digits are used for abbreviation.
    private int abbrLen(int mask){
        int count = n;
        for (int b = 3; b < bn; b <<= 1)
            if ((mask & b) == 0)
                count --;
        return count;
    }

    private void dfs(int bit, int mask){
        int len = abbrLen(mask);
        if(len >= minlen) return;
        boolean match = true;
        for(Integer d : dict){
            if((mask & d) == 0){
                match = false;
                break;
            }
        }
        // a mask which can cover all differences, no need to find more.
        if(match){
            minlen = len;
            minab = mask;
        }
        // No ? Then has to add more masks to cover all differences.
        else{
            for(int b = bit; b < bn; b <<= 1){
                if((cand & b) != 0) dfs(b << 1, mask + b);
            }
        }
    }

    String minAbbreviation(String target, String[] dictionary){
        n = target.length(); bn = 1 << n; cand = 0; minlen = Integer.MAX_VALUE;
        StringBuilder res = new StringBuilder();

        for(String s : dictionary){
            int word = 0;
            if(s.length() != n) continue;
            for(int i = 0; i < n; i++)
                if(target.charAt(i) != s.charAt(i)) word |= 1 << i;
            dict.add(word);
            cand |= word;
        }

        dfs(1, 0);  // DFS : 1 -> 1010 -> 10101
        //                 -> 10100
        //         -> 1011 -> 10110

        for(int i = 0; i < n;){
            if((minab & (1 << i)) != 0){
                res.append(target.charAt(i++));
            }else{
                int j = i;
                while(i < n && (minab & (1 << i)) == 0)i++;
                res.append(i - j);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        MinimumUniqueWordAbbreviation test = new MinimumUniqueWordAbbreviation();
        String target = "apple";
        String[] dict = {"plain", "amber", "blade"};
        System.out.println(test.minAbbreviation(target,dict));
    }
}
