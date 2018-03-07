package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 6/2/16.
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int maj1 = 0 ,maj2 = 0;
        int counter1 = 0, counter2 = 0;
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (num == maj1) {
                counter1 ++;
            } else if (num == maj2) {
                counter2 ++;
            } else if (counter1 == 0) {
                maj1 = num;
                counter1 = 1;
            } else if (counter2 == 0) {
                maj2 = num;
                counter2 = 1;
            } else {
                counter1 --;
                counter2 --;
            }
        }

        counter1 = 0;
        counter2 = 0;
        int size = nums.length;
        for (int num : nums) {
            if (num == maj1) counter1 ++;
            if (num == maj2) counter2 ++;
        }
        if (counter1 > size/3) res.add(maj1);
        if (counter2 > size/3 && maj1 != maj2) res.add(maj2); // nums= [0,0,0]

        return res;
    }


    public static void main (String[] argu) {
        MajorityElementII test = new MajorityElementII();
        int[] nums = {1,2,1,2,1,2,1,2,3};
        System.out.println(test.majorityElement(nums));
    }
}