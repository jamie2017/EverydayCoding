package BitManipulation;

/**
 * Created by JMYE on 6/29/17.
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int diffCnt = 0;
        while (n != 0) {
            diffCnt++;
            n = n & (n - 1);
        }
        return diffCnt;

    }

    public int hammingWeight(int n) {
        int ones = 0;
        while (n != 0) {
            ones += n & 1;
            n = n >>> 1;
        }
        return ones;
    }

    public int hammingDistance2(int x, int y) {
        int n = x ^ y;
        return hammingWeight(n);
    }

    public int hammingDistance3(int x, int y) {
        return Integer.bitCount(x ^ y);
    }


}


/*
Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.



 */