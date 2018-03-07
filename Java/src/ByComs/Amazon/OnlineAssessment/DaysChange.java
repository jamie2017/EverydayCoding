package ByComs.Amazon.OnlineAssessment;

import java.util.Arrays;

/**
 * Created by JMYE on 10/10/16.
 */
public class DaysChange {
    public int[] datsChange(int[] days, int n) {
        if (days == null || n <= 0) return days;
        int length = days.length;
        //两边添加0
        int[] rst = new int[length + 2];
        rst[0] = rst[length + 1] = 0;
        int pre = rst[0];
        for (int i = 1; i <= length; i++)
            rst[i] = days[i-1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= length; j++) {
                int temp = rst[j];
                rst[j] = pre ^ rst[j + 1];
                pre = temp;
            }
        }
        return Arrays.copyOfRange(rst, 1, length+1);
    }


    public static void main (String[] args) {
        int[] cells = {1,0,0,0,0,1,0,0};
        int n = 1;
        DaysChange test = new DaysChange();
        int[] rst = test.datsChange(cells,n);
        for (int r : rst) {
            System.out.println(r);
        }
    }
}
