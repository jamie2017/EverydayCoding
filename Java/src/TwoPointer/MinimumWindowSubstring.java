package TwoPointer;

/**
 * Created by JMYE on 9/3/16.
 */
public class MinimumWindowSubstring { // MARK

    public String minWindow(String Source, String Target) {
        // queueing the position that matches the char in T
        int ans = Integer.MAX_VALUE;
        String minStr = "";

        int[] map = new int[256];

        int targetnum = initTargetHash(map, Target);
        int sourcenum = 0;
        int start = 0, end  ;
        for(end = 0; end < Source.length(); end++) {
            if(map[Source.charAt(end)] > 0)
                sourcenum++;

            map[Source.charAt(end)]--;
            while(sourcenum == targetnum) {
                if(ans > end - start + 1) {
                    ans = Math.min(ans, end - start + 1);
                    minStr = Source.substring(start, end + 1);
                }
                map[Source.charAt(start)]++;
                if(map[Source.charAt(start)] > 0)
                    sourcenum--;
                start ++;
            }
        }
        return minStr;
    }
    private int initTargetHash(int []targethash, String Target) {
        int targetnum =0 ;
        for (char ch : Target.toCharArray()) {
            targetnum++;
            targethash[ch]++;
        }
        return targetnum;
    }
    public static void main (String[] argu) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        MinimumWindowSubstring test = new MinimumWindowSubstring();
        System.out.println(test.minWindow(s,t));
    }
}
