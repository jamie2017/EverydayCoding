package HighFrequency.TopK.TopK;

import java.util.Arrays;

/**
 * Created by JMYE on 11/20/16.
 */
public class KthLargestElement {
    public int kthLargestElement(int k, int[] nums) {
        int pivot = nums[0];
        int tail = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > pivot) {
                tail++;
                swap(nums, tail, i);
            }
        }
        swap(nums, tail, 0);
        if (tail + 1 == k) {
            return pivot;
        } else if (tail + 1 < k) {
            return kthLargestElement(k - tail - 1, Arrays.copyOfRange(nums,tail + 1,nums.length));
        } else {
            return kthLargestElement(k, Arrays.copyOfRange(nums,0,tail));
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 3;
        KthLargestElement test = new KthLargestElement();
        System.out.println(test.kthLargestElement(k,nums));
    }
}

/*
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
 */