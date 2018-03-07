package ByComs.Amazon.OnlineAssessment;

import java.util.Arrays;

/**
 * Created by JMYE on 10/10/16.
 */
public class FourInteger {
    public int[] fourInteger(int A, int B, int C, int D) {
        int[] rst = new int[4];
        rst[0] = A;
        rst[1] = B;
        rst[2] = C;
        rst[3] = D;
        Arrays.sort(rst);
        swap(rst, 0, 1);
        swap(rst, 2, 3);
        swap(rst, 0, 3);
        return rst;
    }

    private void swap(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    private int FS(int[] arr) {
        return Math.abs(arr[0] - arr[1]) + Math.abs(arr[1] - arr[2]) +
                Math.abs(arr[2] - arr[3]);
    }

    public static void main(String[] args) {
        FourInteger test = new FourInteger();
        int a = 3,b = 2, c = 1, d = 4;
        int[] rst  = test.fourInteger(a,b,c,d);
        System.out.println(test.FS(rst));
    }

}
