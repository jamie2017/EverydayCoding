package DP;

/**
 * Created by JMYE on 9/4/16.
 */
public class HouseRobber {
    public long houseRobber(int[] A) {
        // write your code here
        int n = A.length;
        if(n == 0)
            return 0;
        long []res = new long[n+1];


        res[0] = 0;// 序列型DP预留初始化
        res[1] = A[0];
        for(int i = 2; i <= n; i++) {
            res[i] = Math.max(res[i-1], res[i-2] + A[i-1]);
        }
        return res[n];
    }
    /* 滚动数组优化

    public long houseRobber(int[] A) {
        // write your code here
        int n = A.length;
        if(n == 0)
            return 0;
        long []res = new long[2];


        res[0] = 0;
        res[1] = A[0];
        for(int i = 2; i <= n; i++) {
            res[i%2] = Math.max(res[(i-1)%2], res[(i-2)%2] + A[i-1]);
        }
        return res[n%2];
    }
     */
}
