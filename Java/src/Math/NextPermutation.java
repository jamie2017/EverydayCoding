package Math;

/**
 * Created by JMYE on 9/23/16.
 */
public class NextPermutation {
    /*
     1.Find the largest index k such that nums[k] < nums[k + 1] .
     If no such index exists, the permutation is sorted in descending order,
     just reverse it to ascending order and we are done. For example,
     the next permutation of [3,2, 1] is [1, 2, 3] .

     2  Find the largest index l greater than k such that nums[k] < nums[l] .

     3. Swap the value of nums[k] with that of nums[l] .

     4. Reverse the sequence from nums[k + 1] up to
     and including the final element nums[nums.size() - 1] .

     */


    public void nextPermutation(int[] nums) {
        int k = -1;
        for (int i = nums.length - 2; i >=0; i--) {
            if (nums[i] < nums[i + 1]) {
                k = i;
                break;
            }
        }
        if (k == -1) { // 321->123
            reverse(nums,0,nums.length - 1);
            return;
        }
        int peekPoint = -1;
        for (int i = nums.length - 1; i > k; i--) { // 15342, k = 2
            if (nums[i] > nums[k]) {
                peekPoint = i;
                break;
            }
        }
        swap(nums,k,peekPoint); // 15342 -> 15432
        reverse(nums, k + 1,nums.length - 1); // 15432 -> 15423



    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

    }
}
