package Math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 9/14/16.
 */
public class PermutationSequence {//https://discuss.leetcode.com/topic/17348/explain-like-i-m-five-java-solution-in-o-n
    /*
    say n = 4, you have {1, 2, 3, 4}

    If you were to list out all the permutations you have

    1 + (permutations of 2, 3, 4)

    2 + (permutations of 1, 3, 4)

    3 + (permutations of 1, 2, 4)

    4 + (permutations of 1, 2, 3)




     */

    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> nums = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i; // fact = n! = n * (n - 1) *(n - 2) * ... * 1
            nums.add(i); // nums = {1,2,3,4,5,6,7,8,9,...n}
        }

        for (int i = 0, theK = k - 1; i < n; i++) { // l = k - 1 is because nums is zero-based
            fact /= (n - i);
            int index = (theK / fact);
            sb.append(nums.remove(index));
            // ArrayList.remove(index) return the element that being removed
            // which means here sb.append(nums[0]),for which nums[0] is removed from nums
            theK -= index * fact;
        }
        return sb.toString();
    }

}
