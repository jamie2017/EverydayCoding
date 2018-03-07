package ByComs.Amazon.OnlineAssessment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 10/9/16.
 */
public class GrayCode {
    // if can be placed successively in a gray code sequence return 1 else 0
    public static int grayCheck(byte term1, byte term2) {
        // XOR operation by bit
        // for gray code there is only one diff between two terms
        byte rst = (byte)(term1 ^ term2);
        for (int i = 0; i <= 7; i++) {
            byte tmp = (byte)(1 << i);
            if (tmp == rst) {
                return 1;
            }
        }
        return 0;
    }
    /*

    另一版本如下。当两个数互为格雷码，
    则XOR之后结果为七个0和一个1，
    比如，00100000，00100000与00011111相与的结果为0。
    当total大于1时，可证明两个数不
     */

    public static int grayCheck2(byte term1, byte term2) {
        byte x = (byte)(term1 ^ term2);
        int total = 0;
        while(x != 0){
            x = (byte) (x & (x - 1));
            total++;
        }
        if(total == 1) return 1; else return 0;
    }

    public static List<Integer> garyCode(int n) {
        List<Integer> rst = new ArrayList<>();
        for (int i = 0; i < 1<<n; i++) {
            rst.add(i ^ i>>1);
        }
        return rst;
    }
    public static void main(String[] args) {
        byte term1 = (byte)0x0a, term2 = (byte)0x80;
        int out;
//        out = grayCheck(term1, term2);
//        System.out.println(out);
        System.out.println(garyCode(2));
    }
}
