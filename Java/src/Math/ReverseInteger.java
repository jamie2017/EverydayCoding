package Math;

/**
 * Created by JMYE on 8/25/16.
 */
public class ReverseInteger {
    public int reverse(int x) {
//        int result = 0;
//        while (x != 0) {
//            int tail = x % 10;
//            int newResult = result * 10 + tail;
//            if ((newResult-tail)/10 != result) { // in case overflow
//                return 0;
//            }
//            result = newResult;
//            x = x / 10;
//        }
//        return result;
        long rev= 0;
        while( x != 0){
            rev= rev*10 + x % 10;
            x= x/10;
            if( rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
                return 0;
        }
        return (int) rev;
    }

    public static void main(String[] args) {
        ReverseInteger test = new ReverseInteger();
        System.out.println(test.reverse(-123));// -321
        System.out.println(-123%10);
        System.out.println(-123/10);
        System.out.println(test.reverse(-1240000)); // -421
        System.out.println(test.reverse(-1239999999));//0



    }
}
