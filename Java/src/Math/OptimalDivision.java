package Math;

/**
 * Created by JMYE on 5/10/17.
 */
public class OptimalDivision {
    public String optimalDivision(int[] nums) {
        StringBuilder builder = new StringBuilder();
        builder.append(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (i == 1 && nums.length > 2) {
                builder.append("/(").append(nums[i]);
            } else {
                builder.append("/").append(nums[i]);
            }
        }

        return nums.length > 2 ? builder.append(")").toString() : builder.toString();
    }
}
