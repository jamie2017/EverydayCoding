package DP;

/**
 * Created by JMYE on 9/5/16.
 */

/*

For [5, 4, 1, 2, 3], the LIS is [1, 2, 3], return 3
For [4, 2, 4, 5, 3, 7], the LIS is [2, 4, 5, 7], return 4


 */
public class LongestIncreasingSubsequence {
    public int longestIncreasingSubsequence(int[] nums) { // O(n^2)
        // write your code here
        int maxLIS = 0;
        int[] f = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    f[i] = f[i] > f[j] + 1? f[i] : f[j] + 1;
                }
            }
            if (maxLIS < f[i]) {
                maxLIS = f[i];
            }
        }

        return maxLIS;
    }



    /*
    tails is an array storing the smallest tail of all increasing subsequences with length i+1 in tails[i].
For example, say we have nums = [4,5,6,3], then all the available increasing subsequences are:

len = 1   :      [4], [5], [6], [3]   => tails[0] = 3
len = 2   :      [4, 5], [5, 6]       => tails[1] = 5
len = 3   :      [4, 5, 6]            => tails[2] = 6
We can easily prove that tails is a increasing array. Therefore it is possible to do a binary search in tails array to find the one needs update.

Each time we only do one of the two:

(1) if x is larger than all tails, append it, increase the size by 1
(2) if tails[i-1] < x <= tails[i], update tails[i]

     */
//    public int LIS_BinarySearch(int[] nums) {
//        int[] tails = new int[nums.length];
//        int size = 0;
//        for (int x : nums) {
//            int i = 0, j = size;
//            while (i != j) {
//                int m = (i + j) / 2;
//                if (tails[m] < x)
//                    i = m + 1;
//                else
//                    j = m;
//            }
//            tails[i] = x;
//            if (i == size) ++size;
//        }
//        return size;
//    }

    public static int LIS_BS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] tails = new int[nums.length];
        tails[0] = nums[0];
        int len = 0;
        for (int i = 1; i < nums.length;i++) {
            int pos = binarySearch(tails, len, nums[i]);
            if (pos > len) {
                len = pos;
                tails[len] = nums[i];
            } else {
                tails[pos] = nums[i];
            }
        }
        return len + 1;// because len is the zero based index, so need to + 1 for length
    }

    private static int binarySearch(int[] tails, int len, int val) {
        int left = 0, right = len;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (tails[mid] == val) {
                return mid;
            } else {
                if (tails[mid] > val) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
        }
        if (tails[right] < val) return len + 1;
        else if (tails[left] >= val) return left;
        else return right;
    }


    public static void main(String[] args) {
        int[] nums = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        System.out.println(LIS_BS(nums));
    }




}
