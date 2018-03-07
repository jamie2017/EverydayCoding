package ByComs.Amazon.OnlineAssessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by JMYE on 10/9/16.
 */
public class WindowSum {
    public List<Integer> getSum(List<Integer> A, int k) {
        List<Integer> rst  = new ArrayList<>();
        if (A == null || A.size() == 0 || k <= 0) return rst;
        int len = A.size();
        for (int i = 0; i + k - 1 < len; ++i) {
            int sum = 0;
            for (int j = 0; j < k; ++j) {
                sum += A.get(i + j);
            }
            rst.add(i, sum);
        }
        return rst;
    }
    public int[] Solution(int[] array, int k) {
        if (array == null || array.length < k || k <= 0)    return null;
        int[] rvalue = new int[array.length - k + 1];
        for (int i = 0; i < k; i++)
            rvalue[0] += array[i];
        for (int i = 1; i < rvalue.length; i++) {
            rvalue[i] = rvalue[i-1] - array[i-1] + array[i+k-1];
        }
        return rvalue;
    }

    public static void main(String[] args) {
        int k = 3;
        WindowSum test = new WindowSum();
        List<Integer> A = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        System.out.println(test.getSum(A,k));
    }
}
