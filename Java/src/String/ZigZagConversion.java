package String;

/**
 * Created by JMYE on 9/13/16.
 */
public class ZigZagConversion {
    public static String convert(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++){
            sb[i] = new StringBuffer();
        }

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) {// vertically down
                sb[idx].append(c[i++]);
            }
            for (int idx = nRows - 2; idx >= 1 && i < len; idx--) {// obliquely up
                sb[idx].append(c[i++]);
            }
        }
        for (int idx = 1; idx < sb.length; idx++) {
            sb[0].append(sb[idx]);
        }
        return sb[0].toString();
    }

    /*n=numRows
Δ=2n-2    1                           2n-1                         4n-3
Δ=        2                     2n-2  2n                    4n-4   4n-2
Δ=        3               2n-3        2n+1              4n-5       .
Δ=        .           .               .               .            .
Δ=        .       n+2                 .           3n               .
Δ=        n-1 n+1                     3n-3    3n-1                 5n-5
Δ=2n-2    n                           3n-2                         5n-4
*/

    /*n=numRows
    Δ=2n-2    0                           2n-2                         4n-4
    Δ=        1                     2n-3  2n-1                    4n-5 4n-3
    Δ=        2               2n-4        2n              4n-6       .
    Δ=        .           .               .               .            .
    Δ=        .       n+1                 .           3n-1               .
    Δ=        n-2 n                       3n-4    3n-2                 5n-6
    Δ=2n-2    n-1                         3n-3                         5n-5
    */
    public String convert2(String s, int numRows) {
        if(numRows == 1)    return s;
        StringBuilder b = new StringBuilder();
        int gap = 2 * numRows - 2;
        int sLen = s.length();
        for(int i = 0; i < numRows; i++){
            int j = i;
            while(j < sLen){
                if(gap != 0)
                    b.append(s.charAt(j));
                j += gap;
                if(i != 0 && j < sLen)
                    b.append(s.charAt(j));
                j += 2 * i;
            }
            gap -= 2;
        }
        return b.toString();
    }

    public static void main(String[] args) {
        String s = "ABC";
        int n = 2;
        System.out.println(convert(s,n));
    }

}
