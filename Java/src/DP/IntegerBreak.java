package DP;

/**
 * Created by JMYE on 9/14/16.
 */
public class IntegerBreak {
    //all factors should be 2 or 3 (N > 4)
    //3 * 3 > 2 * 2 * 2.
    public int integerBreak(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        int product = 1;
        while(n > 4){
            product *= 3;
            n -= 3;
        }
        product *= n;

        return product;
    }
}
