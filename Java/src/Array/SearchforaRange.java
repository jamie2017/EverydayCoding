package Array;

/**
 * Created by JMYE on 9/12/16.
 */
public class SearchforaRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1,1};
        }

        int start, end, mid;
        int[] bound = new int[2];


        // search for left bound;
        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else  {
                start = mid + 1;
            }
        }

        if (nums[start] == target) {
            bound[0] = start;
        } else if (nums[end] == target) {
            bound[0] = end;
        } else {
            bound[0] = bound[1] = -1;
            return bound;
        }

        // search for right bound
        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[end] == target) {
            bound[1] = end;
        } else if (nums[start] == target) {
            bound[1] = start;
        } else {
            bound[0] = bound[1] = -1;
            return bound;
        }
        return bound;

    }
    // another shorter solution

    public int[] searchRange2(int[] A, int target) { // SMART
        int start = firstGreaterEqual(A, target);
        if (start == A.length || A[start] != target) {
            return new int[]{-1, -1};
        }
        // the end bound is the indexof (target + 1) - 1
        return new int[]{start, firstGreaterEqual(A, target + 1) - 1};
    }

    //find the first number that is greater than or equal to target.
    //could return A.length if target is greater than A[A.length-1].
    //actually this is the same as lower_bound in C++ STL.
    private  int firstGreaterEqual(int[] A, int target) {
        int low = 0, high = A.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            //low <= mid < high
            if (A[mid] < target) {
                low = mid + 1;
            } else {
                //should not be mid-1 when A[mid]==target.
                //could be mid even if A[mid]>target because mid<high.
                high = mid;
            }
        }
        return low;
    }
}
