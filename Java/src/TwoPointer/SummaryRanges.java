package TwoPointer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 11/4/16.
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {

        List<String> rst = new ArrayList<>();
        if (nums == null || nums.length == 0) return rst;

        int L = 0, R = 0;
        while(R < nums.length) {
            R++;
            if (R < nums.length && nums[R - 1] + 1 == nums[R]) continue;
            if (L == R - 1) {
                rst.add(nums[L] + "");
            } else {
                rst.add(nums[L] + "->" + nums[R - 1]);
            }
            L = R;
        }
        return rst;
    }
}
