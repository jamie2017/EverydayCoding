package ByComs.WePay;

import java.util.TreeSet;

/**
 * Created by JMYE on 8/9/17.
 */
public class PowerNumber {
    public static boolean check(int a) {
        if (a <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(a); i++) {
            double value = Math.log(a) / Math.log(i);
//            if (value % 1 == 0) return true;
            if ((value - (int) value) < 0.00000000001) {
                return true;
            }
        }
        return false;
    }


    public static boolean check2(int x) {
        int bound = (int)Math.sqrt(x) + 1;
        for (int i = 2; i < bound;i++) {
            if (checkIfPowerOfAnother(i,x)) return true;
        }
        return false;
    }

    private static boolean checkIfPowerOfAnother(int x, int y) {
        if (x >= y) return false;
        int power = 1;
        while (power < y) {
            power *= x;
        }
        return power == y;


    }

    public static  int getNthPowerNumber(int index) {
        int ithPowerNum = 4;
        if (index == 0) {
            return ithPowerNum;
        }
        int i = 0;
        while (true) {
            if (check(ithPowerNum)) {
                if (i == index) return ithPowerNum;
                i ++;
            }
            ithPowerNum ++;
        }
    }

    public static int getPowerNumber(int index) {
        int max = (int) Math.pow(index + 2, 2); // index'th power number will not be greater than (index + 2)^2
        TreeSet<Integer> set = new TreeSet<>(); // use set to avoid duplicate, treeset provides ordering by key
        for (int base = 2; base <= index + 2; base ++) {
            for (int power = 2; (int) Math.pow(base, power) <= max; power ++) {
                set.add((int) Math.pow(base, power));
            }
        }
        System.out.println(set.size());
        while (index-- > 0){
            System.out.println(set.pollFirst());
        }
        return set.first();

    }

    public static void main(String[] args) {
//        System.out.println(check(125));
        System.out.println(getPowerNumber(200));
    }
}
