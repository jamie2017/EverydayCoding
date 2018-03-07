package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 9/12/16.
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        for(int i : nums) {
            if(i > lower) res.add(getRange(lower, i - 1));

            if(i == upper) return res; // Avoid overflow
            lower = i+1;
        }
        res.add(getRange(lower, upper));
        return res;
    }


    private String getRange(int lower, int upper) {
        if (lower == upper) {
            return lower +"";
        } else {
            return lower + "->" + upper;
        }
    }

    public static void main(String[] args) {
        MissingRanges test = new MissingRanges();
        int[] nums= {-2147483648,-2147483648,0,2147483647,2147483647};

        int lower = -2147483648, upper = 2147483647;

        System.out.println(test.findMissingRanges(nums,lower,upper));
    }



}
