package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 6/29/17.
 *
 Add to List
 442. Find All Duplicates in an Array
 */
public class FindAllDuplicatesinanArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> dups = new ArrayList<>();
        for (int num: nums) {
            if (nums[Math.abs(num) - 1] < 0) {
                dups.add(Math.abs(num));
            } else {
                nums[Math.abs(num) - 1] *= -1;
            }
        }
        return dups;
    }
}


/*

Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
 */