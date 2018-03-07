package BitManipulation;

/**
 * Created by JMYE on 8/24/16.
 */
public class SumTwoIntegers { // MARK
    // Iterative
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        // a=7:111
        // b=4:100
        // a & b -> 100
        // a ^ b -> 011
        while (b != 0) {
            int carry = a & b;
            a = a ^ b; // XOR
            b = carry << 1; // 1000
        }

        return a;
    }
    // Recursive
    public int getSum_recursive(int a, int b) {
        // & 进位 ^ 加
        return (b == 0) ? a : getSum_recursive(a ^ b, (a & b) << 1);
    }


    public int getSubtract(int a, int b) {
        while (b != 0) {
            int borrow = (~a) & b;
            a = a ^ b;
            b = borrow << 1;
        }

        return a;
    }

    // Recursive
    public int getSubtract_recursive(int a, int b) {
        return (b == 0) ? a : getSubtract_recursive(a ^ b, (~a & b) << 1);
    }

    // Get negative number
    public int negate(int x) {
        return ~x + 1;
    }
}
