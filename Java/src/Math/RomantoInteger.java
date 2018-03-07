package Math;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JMYE on 8/29/16.
 */
public class RomantoInteger {
    public static int romanToInt(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    res += (res >= 5 ? -1 : 1);
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    res += 10 * (res >= 50 ? -1 : 1);
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    res += 100 * (res >= 500 ? -1 : 1);
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
        }
        return res;
    }

    public int romanToIntOpt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('M',1000);
        romanMap.put('D',500);
        romanMap.put('C',100);
        romanMap.put('L',50);
        romanMap.put('X',10);
        romanMap.put('V',5);
        romanMap.put('I',1);
        int ans = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            if (romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i + 1))) {
                ans -= romanMap.get(s.charAt(i));
            } else {
                ans += romanMap.get(s.charAt(i)) ;
            }
        }
        return ans + romanMap.get(s.charAt(s.length() - 1));
    }
}
