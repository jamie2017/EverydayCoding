package BinarySearch;

/**
 * Created by JMYE on 11/5/16.
 */
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        int stair = 1;
        if (n == 0) return 0;
        if (n == 1) return stair;
        while (n > 0) {
            n = n - stair;
            if (n <= stair) {
                break;
            }
            stair++;
        }
        return stair;
    }

    public int arrangeCoins_math(int n) {
        return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
        /*
        (1 + X) * X = 2n
        4X * X + 4 * X = 8n
        (2X + 1)(2X + 1) - 1 = 8n
        X = (Math.sqrt(8 * n + 1) - 1)/ 2
         */
    }

    public int arrangeCoins_binarysearch(int n) {
        long nLong = (long)n;

        long st = 0;
        long ed = (nLong/2) + 1;

        long mid = 0;

        while (st <= ed){
            mid = st + (ed - st) / 2;

            if (mid * (mid + 1) <= 2 * nLong){
                st = mid + 1;
            }else{
                ed = mid - 1;
            }
        }

        return (int)(st - 1);
    }
}
