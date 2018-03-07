package Array;

/**
 * Created by JMYE on 9/14/16.
 */
public class RotateFunction {
    public int maxRotateFunction(int[] A) { // SMART
        int n = A.length;
        int sum = 0;
        int candidate = 0;

        // A = [4,3,2,6]
        // sum = 1*4+1*3+1*2+1*6 = 15
        // candidate = 0*4 + 1*3 + 2*2 + 3*6 = 25


        for (int i = 0; i < n; i++) {
            sum += A[i];
            candidate += A[i] * i;
        }
        int best = candidate;

        for (int i = n - 1; i > 0; i--) { // genius
            candidate = candidate + sum - A[i] * n;
            //   0*4 + 1*3 + 2*2 + 3*6 = F(0)
            // + 1*4 + 1*3 + 1*2 + 1*6
            // -                   4*6
            // = 1*4 + 2*3 + 3*2 + 0*6 = F(1)

            //   1*4 + 2*3 + 3*2 + 0*6 = F(1)
            // + 1*4 + 1*3 + 1*2 + 1*6
            // -             4*2
            // = 2*4 + 3*3 + 0*2 + 1*6 = F(2)

            //   2*4 + 3*3 + 0*2 + 1*6 = F(2)
            // + 1*4 + 1*3 + 1*2 + 1*6
            // -       4*3
            // = 3*4 + 0*3 + 1*2 + 2*6 = F(3)

            best = Math.max(best, candidate);
        }
        return best;
    }

    public static void main(String[] args){
        int[] A = {4,3,2,6};
        RotateFunction test = new RotateFunction();
        System.out.println(test.maxRotateFunction(A));
    }
}
