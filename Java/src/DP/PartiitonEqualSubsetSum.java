package DP;

/**
 * Created by JMYE on 11/5/16.
 */
public class PartiitonEqualSubsetSum { // store temporal data
                                       // from 1d to 2d , apply dp

    public static boolean canPartition(int[] nums) {
        if (nums.length == 2) {
            return nums[0] == nums[1];
        }
        int targetSum = sumOfNums(nums) ;
        if (targetSum % 2 == 0) {
            targetSum /= 2;
        } else {
            return false;
        }

        return isSubsetSum_dp(nums, targetSum);
    }

    private static int sumOfNums(int[] nums) {
        int rst = 0;
        for (int num: nums) {
            rst += num;
        }
        return rst;
    }

    public static boolean isSubsetSum_dp(int input[], int total) {

        boolean dp[][] = new boolean[input.length + 1][total + 1];
        // dp[i][j] = 数组前i个数里面能否找个和等于j的子数组
        // dp[i][j] = true if sum(input[:i + 1]) = j else false
        for (int i = 0; i <= input.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= input.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (j - input[i - 1] >= 0) { // input[i-1] here because arr is zero-based
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - input[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[input.length][total];

    }


    // 压缩空间 O(sum)
    public static boolean canPartitionEqualSum(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        for (int i = 0; i <= sum; i++) {
            dp[i] = false;
        }
        dp[0] = true;
        for (int i = 0; i < len; i++) {
            for(int j = sum; j >= nums[i]; j--) {
                dp[j] |= dp[j - nums[i]];
            }
        }
        return dp[sum];
    }
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};

        System.out.println(canPartition(nums));
        System.out.println(canPartitionEqualSum(nums));
    }
}
