package Array;
import java.util.Arrays;
/**
 * Created by JMYE on 10/2/16.
 */
public class WiggleSortII {
    // sort O(nlogn)
    public void wiggleSort_sort(int[] nums) {
        Arrays.sort(nums);
        int[] tmp = new int[nums.length];
        int s = (nums.length + 1) >> 1, t = nums.length;
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = (i & 1) == 0 ? nums[--s] : nums[--t];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = tmp[i];
        }
    }


   // average O(n) worsest O(n^2)

    public void wiggleSortII(int[] nums) {
        // O(n)
        int medium = findMedium(nums, 0, nums.length - 1, (nums.length + 1)>>1);
        int s = 0, t = nums.length - 1, mid_index = (nums.length + 1) >> 1;
        int[] tmp = new int[nums.length];
        // O(n)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < medium) {
                tmp[s++] = nums[i];
            } else if (nums[i] > medium) {
                tmp[t--] = nums[i];
            }
        }
        while (s < mid_index) tmp[s++] = medium;
        while (t >= mid_index) tmp[t--] = medium;
        // after these two while, tmp is in asceding order
        t = nums.length;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (i & 1) == 0 ? tmp[--s] : tmp[--t];
        }

    }

    private int findMedium(int[] nums, int L, int R, int k) {
        if (L >= R) return nums[R];
        int i = partition(nums, L, R);
        int cnt = i - L + 1;
        if (cnt == k) return nums[i];
        return cnt > k ? findMedium(nums, L, i - 1, k) : findMedium(nums, i + 1, R, k - cnt);
    }

    private int partition(int[] nums, int L, int R) {
        int val = nums[L];
        int i = L, j = R + 1;
        while (true) {
            while (++i < R && nums[i] < val) ;
            while (--j > L && nums[j] > val) ;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, L, j);
        return j;
    }



    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2,2,2, 3, 1};
        WiggleSortII test = new WiggleSortII();
        test.wiggleSortII(nums);
        for (int n : nums) {
            System.out.println(n);
        }
    }



// MARK
    /*
(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].


(1) elements smaller than the 'median' are put into the last even slots

(2) elements larger than the 'median' are put into the first odd slots

(3) the medians are put into the remaining slots.

Index :       0   1   2   3   4   5
Small half:   M       S       S
Large half:       L       L       M
     */


    public void wiggleSort(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;

        int left = 0, i = 0, right = n - 1;

        while (i <= right) {

            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }


    }

    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }

    public int findKthLargest(int[] nums, int k) { // O(n) quick select MARK
        int n = nums.length;
        int p = quickSelect(nums,0, n - 1, n - k + 1);
        return nums[p];
    }

    private int quickSelect(int[] nums, int low, int high, int k) {
        int i = low, j = high, pivot = nums[high];
        while (i < j) {
            if (nums[i++] > pivot) swap(nums,--i,--j);
        }
        swap(nums,i,high);

        int m = i - low + 1;

        if (m == k) return i;
        else if (m > k) return quickSelect(nums, low, i - 1, k);
        else return quickSelect(nums,i + 1, high, k - m);
    }



    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
