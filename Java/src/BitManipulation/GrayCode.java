package BitManipulation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by JMYE on 9/15/16.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> rst = new ArrayList<>();
        for (int i = 0; i < 1<<n; i++) { // 1<<2 = 4
            System.out.println("i" + i);
            System.out.println("i in binary: " + Integer.toBinaryString(i));
            System.out.println("i shift to right by one" + Integer.toBinaryString(i>>1));
            System.out.println(Integer.toBinaryString(i ^ i>>1));
            System.out.println();
            rst.add(i ^ i>> 1);
        }
        return rst;
    }
    public static void main(String[] args) {
        int n = 2;
        GrayCode test = new GrayCode();
        System.out.println(test.grayCode(n));
    }
}
