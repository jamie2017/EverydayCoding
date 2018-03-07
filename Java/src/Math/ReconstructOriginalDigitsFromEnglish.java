package Math;

import java.util.*;

/**
 * Created by JMYE on 11/28/16.
 */
public class ReconstructOriginalDigitsFromEnglish {
    /*
    The even digits all have a unique letter while the odd digits all don't:

zero: Only digit with z
two: Only digit with w
four: Only digit with u
six: Only digit with x
eight: Only digit with g

The odd ones for easy looking, each one's letters all also appear in other digit words:
one, three, five, seven, nine
     */
    public static String originalDigits(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else{
                map.put(c,map.get(c) + 1);
            }
        }
        int[] ans = new int[10];
        String[] facts = "0eroz 6six 7evens 5fiev 8eihtg 4ourf 3treeh 2tow 1neo 9nnei".split(" ");
        for (String x : facts) {
            char key = x.charAt(x.length() - 1);
            if (!map.containsKey(key)) continue;
            ans[x.charAt(0) - '0'] = map.get(key);
            for (char c: x.toCharArray()) {
                if (map.containsKey(c)) {
                    map.put(c,map.get(c) - map.get(key));
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for(int j = 0; j < ans[i]; j++) {
                res.append(i);
            }
        }
        return res.toString();
    }
    // solutiotn 2
    public String originalDigits2(String s) {
        int[] count = new int[10];
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == 'z') count[0]++;
            if (c == 'w') count[2]++;
            if (c == 'x') count[6]++;
            if (c == 's') count[7]++; //7-6
            if (c == 'g') count[8]++;
            if (c == 'u') count[4]++;
            if (c == 'f') count[5]++; //5-4
            if (c == 'h') count[3]++; //3-8
            if (c == 'i') count[9]++; //9-8-5-6
            if (c == 'o') count[1]++; //1-0-2-4
        }
        count[7] -= count[6];
        count[5] -= count[4];
        count[3] -= count[8];
        count[9] = count[9] - count[8] - count[5] - count[6];
        count[1] = count[1] - count[0] - count[2] - count[4];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++){
            for (int j = 0; j < count[i]; j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "fviefurozerozero";
        System.out.println(originalDigits(s));
    }
}
