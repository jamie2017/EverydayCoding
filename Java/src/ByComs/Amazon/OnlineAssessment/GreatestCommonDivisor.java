package ByComs.Amazon.OnlineAssessment;

/**
 * Created by JMYE on 10/9/16.
 */

/*

题目
找一个数组中所有数的最大公约数。

欧几里得算法
又称为辗转相除法，用于计算两个整数a和b的最大公约数。
定理：gcd(a,b) = gcd(b,a mod b)

证明：a可以表示成a = kb + r，则r = a mod b
假设d是a,b的一个公约数，则有
d|a, d|b，而r = a - kb，因此d|r
因此d是(b,a mod b)的公约数

假设d 是(b,a mod b)的公约数，则
d | b , d |r ，但是a = kb +r
因此d也是(a,b)的公约数

因此(a,b)和(b,a mod b)的公约数是一样的，其最大公约数也必然相等，得证。

*/

public class GreatestCommonDivisor {
    public int getGCD(int[] arr) {
        int len = arr.length;
        int rst = arr[0];
        for (int i = 1; i < len; i++) {
            rst = gcd2(rst, arr[i]);
        }
        return rst;
    }

    private int gcd(int num1, int num2) {
        if (num1 == num2) {
            return num1;
        }

        int div = Math.min(num1, num2);
        if (div == 0) {
            return Math.max(num1, num2);
        }
        int or1 = num1, or2 = num2;

        while (or1 % div != 0 || or2 % div != 0) {
            if (Math.max(num1,num2) % Math.min(num1,num2) == 0) {
                return Math.min(num1,num2);
            } else {
                div = Math.max(num1, num2) % Math.min(num1, num2);
            }
            num1 = Math.min(num1, num2);
            num2 = div;
        }
        return div;
    }


    private int gcd2(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        if (num2 == 0) {
            return num1;
        }
        if ((num1 & 1) == 0 && (num2 & 1) == 0) {
            return 2*gcd(num1 >>1, num2 >> 1);
        } else if ((num1 & 1) == 0) {// (num1 & 1) == num1 % 2
            return gcd(num1 >> 1, num2);
        } else if ((num2 & 1) == 0) {
            return gcd(num1 ,num2 >> 1);
        } else {
            return gcd(Math.abs(num1 - num2), Math.min(num1,num2));
        }
    }


    public static void main(String[] args) {
        GreatestCommonDivisor test = new GreatestCommonDivisor();
        int[] arr = {24,12,8,16,28};
        System.out.println(test.getGCD(arr));
    }
}
