package Heap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by JMYE on 9/13/16.
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set4Validate = new HashSet<>();
        List<String> rv = new ArrayList<>();
        char[] map = new char[26];
        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;

        for(int i = 0; i < s.length() - 9; i++) {
            int v = 0;
            for(int j = i; j < i + 10; j++) {
                v <<= 2; // 00 -> 0000
                //  0000
                // |  01
                //  0001
                v |= map[s.charAt(j) - 'A'];
            }
            if(!set1.add(v) && set4Validate.add(v)) { // cool!!! SMART
                rv.add(s.substring(i, i + 10));
            }
        }


        /*

        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            value <<= 2;
            value |= map[s.charAt(i) - 'A'];
            value &= 0xfffff;
            if (i < 9) {
                continue;
            }
            if (!word.add(value) && secondWord.add(value)) {
                result.add(s.substring(i - 9, i + 1));
            }
        }
         */
        return rv;
    }
}
