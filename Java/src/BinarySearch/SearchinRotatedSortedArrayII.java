package BinarySearch;

/**
 * Created by JMYE on 9/12/16.
 */
public class SearchinRotatedSortedArrayII {
    // 这个问题在面试中不会让实现完整程序
    // 只需要举出能够最坏情况的数据是 [1,1,1,1... 1] 里有一个0即可。
    // 在这种情况下是无法使用二分法的，复杂度是O(n)
    // 因此写个for循环最坏也是O(n)，那就写个for循环就好了
    //  如果你觉得，不是每个情况都是最坏情况，你想用二分法解决不是最坏情况的情况，那你就写一个二分吧。
    //  反正面试考的不是你在这个题上会不会用二分法。这个题的考点是你想不想得到最坏情况。

    public boolean search(int[] nums, int target) { // 1151111
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = l + (r - l)/2;
            if (nums[m] == target) return true; //return m in Search in Rotated Array I
            if (nums[l] < nums[m]) { //left half is sorted
                if (nums[l] <= target && target < nums[m])
                    r = m - 1;
                else
                    l = m + 1;
            } else if (nums[l] > nums[m]) { //right half is sorted
                if (nums[m] < target && target <= nums[r])
                    l = m + 1;
                else
                    r = m - 1;
            } else l++;
        }
        return false;
    }
}
