package ByComs.Amazon.OA2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by JMYE on 10/9/16.
 */
public class WindowSum {
    public List<Integer> getSum(List<Integer> list, int k) {
        List<Integer> rst = new ArrayList<>();
        if (list == null || list.size() == 0) {
            return rst;
        }
        for (int i = 0; i < list.size() - k + 1; i ++) { // O(nk)
            int tmpSum = 0;
            for(int j = 0; j < k; j++) {
                tmpSum += list.get(i + j);
            }
            rst.add(tmpSum);
        }
        return rst;
    }


    public List<Integer>calculateWindowSum(List<Integer> list, int windowSize) { // O(n)
        List<Integer> rst = new ArrayList<>();
        if (list == null || list.size() == 0) {
            return rst;
        }
        int cumsum = 0;
        for (int i = 0; i < list.size(); i++) {
            cumsum += list.get(i);
            if (i - windowSize + 1 >= 0) {
                rst.add(cumsum);
                cumsum -= list.get(i - windowSize + 1);
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int k = 2;
        WindowSum test = new WindowSum();
        List<Integer> A = new ArrayList<>(Arrays.asList(4,2,73,11,-5));
        System.out.println(test.getSum(A,k));
        System.out.println(test.calculateWindowSum(A,k));//[6, 75, 84, 6]
    }
}
