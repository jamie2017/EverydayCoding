package DP;

/**
 * Created by JMYE on 9/17/16.
 */
public class DecodeWays {
    public int numDecodings(String s) { // O(n)
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1: 0;

        for(int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }

            int twoDigists = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            if (twoDigists >= 10 && twoDigists <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
// special case when s = '1000' need to handle zero
    public int numDecodings_1(String s) {
        if(s==null || s.length()==0)
            return 0;

        int i = 0;
        int d2 = 1;
        int d1 = (s.charAt(i) != '0') ? 1 : 0;

        int numDec = d1;  // numDecodes till position i
        if(numDec==0) return numDec; // starting with zero, no decode possible

        for(i=1; i<s.length(); i++){
            numDec = 0;
            if(s.charAt(i) != '0'){
                numDec = d1;
            }

            // check if the two chars i-1 and i form a valid decoding
            int val = Integer.parseInt(s.substring(i-1, i+1));
            if(val >9 && val <= 26){
                numDec += d2;
            }
            if(numDec == 0) return numDec;

            d2 = d1;
            d1 = numDec;
        }

        return numDec;
    }






    /*
    def numDecodings(self, s):
    return reduce(lambda(v,w,p),d:(w,(d>'0')*w+(9<int(p+d)<27)*v,d),s,(0,s>'',''))[1]*1



    More readable version:

def numDecodings(self, s):
    v, w, p = 0, int(s>''), ''
    for d in s:
        v, w, p = w, (d>'0')*w + (9<int(p+d)<27)*v, d
    return w
w tells the number of ways
v tells the previous number of ways
d is the current digit
p is the previous digit
     */
}
