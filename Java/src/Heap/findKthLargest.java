package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by JMYE on 7/9/16.
 */
public class findKthLargest {
    public int findKthLargest1(int[] nums, int k) {//O(N lg K) running time + O(1) memory
        int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }


    public int findKthLargest(int[] nums, int k) { // O(nlogk)
        Queue<Integer> heap = new PriorityQueue<>(nums.length);
        for (int num : nums) {
            heap.add(-num);
        }
        while (k > 1) {
            heap.poll();
            k--;
        }
        return -heap.peek();
    }



     public int findKthLargest3(int[] nums, int k) { // O(n) quick select MARK
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




     // jiuzhang template

    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (k <= 0) {
            return 0;
        }
        return helper(nums, 0, nums.length - 1, nums.length - k + 1);

    }
    public int helper(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[l];
        }
        int position = partition(nums, l, r);
        if (position + 1 == k) {
            return nums[position];
        } else if (position + 1 < k) {
            return helper(nums, position + 1, r, k);
        }  else {
            return helper(nums, l, position - 1, k);
        }
    }
    public int partition(int[] nums, int l, int r) {
        // 初始化左右指针和pivot
        int left = l, right = r;
        int pivot = nums[left];

        // 进行partition
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }

        // 返还pivot点到数组里面
        nums[left] = pivot;
        return left;
    }








     public static void main(String[] args) {
         int[] nums = {9,3,2,4,8};
         findKthLargest test = new findKthLargest();
         int k = 1;
         System.out.println(test.findKthLargest3(nums,2));
         for (int num: nums) {
             System.out.println(num);
         }


     }
}
