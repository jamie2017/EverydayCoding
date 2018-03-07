package Math;

/**
 * Created by JMYE on 11/5/16.
 */
public class WaterandJugProblem {
    public static boolean canMeasureWater(int x, int y, int z) {
        //limit brought by the statement that water is finallly in one or both buckets
        if(x + y < z) return false;
        //case x or y is zero
        if( x == z || y == z || x + y == z ) return true;

        //get GCD, then we can use the property of Bézout's identity
        return z%GCD(x, y) == 0;
    }

    public static int GCD(int a, int b){// GCD: greatest common divisor
                                 // eg. GCD(8,12) = 4
        while(b != 0 ){
            int temp = b;
            b = a%b;
            System.out.println(b);
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(GCD(8,12));
    }
}
