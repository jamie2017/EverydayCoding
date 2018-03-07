package LinkedList;

/**
 * Created by JMYE on 11/5/16.
 * Modifyed by JMYE on 07/13/2017
 * 335. Self Crossing
 */
public class SelfCrossing {
    public boolean isSelfCrossing(int[] x) {
        if (x.length < 3) {
            return false;
        }

        for (int i = 3; i < x.length; i++) {
            if (x[i] >= x[i - 2] && x[i - 1] <= x[ i - 3]) return true; // case 1
            if (i >= 4                                      // case 2
                    && x[i - 1] == x[i - 3]
                    && x[i] + x[i - 4] >= x[i - 2]){
                return true;
            }
            if (i >= 5                                     // case 3
                    && x[i - 2] >= x[i - 4]
                    && x[i] + x[i - 4] >= x[i - 2]
                    && x[i - 1] + x[i - 5] >= x[i - 3]
                    && x[i - 1] <= x[i - 3]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] x= {3,3,4,2,2};
        SelfCrossing test = new SelfCrossing();
        System.out.println(test.isSelfCrossing(x));
    }
}
