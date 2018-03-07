package Array;

import java.util.Arrays;

/**
 * Created by JMYE on 9/12/16.
 */
public class MissingNumber { // a^b^b =a; b^b = 0; 0 ^ a = a
    // !!! a ^ 1 = a - 1 if a is odd
    // !!! a ^ a = a + 1 if a is even
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
    public int missingNumber2(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing += i - nums[i];
        }
        return missing;
    }
    // If the array is in order, I prefer Binary Search method. Otherwise, the XOR method is better.
    public int missingNumber_binarySearch(int[] nums) { //binary search
        Arrays.sort(nums);
        int left = 0, right = nums.length, mid= (left + right)/2;
        while(left<right){
            mid = (left + right)/2;
            if(nums[mid]>mid) right = mid;
            else left = mid+1;
        }
        return left;
    }

}
