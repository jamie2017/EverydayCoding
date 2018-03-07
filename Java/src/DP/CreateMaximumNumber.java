package DP;

/**
 * Created by JMYE on 9/24/16.
 */
public class CreateMaximumNumber { //(m+n)^3 MARK


    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[k];
        for (int i = Math.max(0, k - m); i <= k && i <= n; i++) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidate, 0, ans, 0)) ans = candidate; // !! call greater() again here
        }
        return ans;
    }
    private int[] merge(int[] nums1, int[] nums2, int k) {// merge by compare two maximum number of two arrays
        int[] ans = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; ++r)
            ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return ans;
    }

    // compare if nums1 >= nums2
    public boolean greater(int[] nums1, int i, int[] nums2, int j) { // O(n)

        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    // [6,0,4], k = 2
    // return 6,4
    public int[] maxArray(int[] nums, int k) { // O(n)
        int n = nums.length;
        int[] ans = new int[k];
        for (int i = 0, j = 0; i < n; i++) {
            while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]) j--;
            if (j < k) ans[j++] = nums[i];
        }
        return ans;
    }

    public static void main (String[] args) {
        int[] nums1 = {6,7};
        int[] nums2 = {6,0,4};
        int k = 4;
        CreateMaximumNumber test = new CreateMaximumNumber();

        int[] rst;
        rst = test.maxNumber(nums1, nums2, k);
        for (int num: rst) {
            System.out.print(num +" ");
        }
    }

}
