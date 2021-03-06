package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 6/29/17.
 * 448. Find All Numbers Disappeared in an Array
 */
public class FindAllNumbersDisappearedinanArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missing = new ArrayList<>();
        for (int num: nums) { // all appear num's index will be mark
            if (nums[Math.abs(num) - 1] > 0) {
                nums[Math.abs(num) - 1] *= -1;
            }
        }
        for (int i = 0; i < nums.length;i++) {
            if (nums[i] > 0) {
                missing.add(i + 1);
            }
        }
        return missing;

    }
}


/*
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]


 */