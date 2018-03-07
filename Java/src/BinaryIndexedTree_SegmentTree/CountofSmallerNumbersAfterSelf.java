package BinaryIndexedTree_SegmentTree;

import java.util.*;

/**
 * Created by JMYE on 11/20/16.
 */
public class CountofSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - min + 1;
            max = Math.max(max, nums[i]);
        }

        List<Integer> rst = new ArrayList<>();
        int[] BITree = new int[max + 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            rst.add(0,getSum(BITree, nums[i] - 2));

            updateBITree(BITree, nums[i] - 1, 1);
        }
        return rst;
    }


    public List<Integer> countSmaller2(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();

        // clone the original array and sort it, store <value, position> into hash map
        Map<Integer, Integer> map = new HashMap<>();
        int[] sortedNum = nums.clone();
        Arrays.sort(sortedNum);
        for(int i = 0; i < nums.length; i++) map.put(sortedNum[i], i);

        // create fenwick tree whose length is one larger than the original array
        int[] fenwickTree = new int[nums.length + 1];
        List<Integer> res = new ArrayList<>();
        for(int i = nums.length - 1; i >= 0; i--) {
            res.add(0, getSum(fenwickTree, map.get(nums[i]) - 1));
            updateBITree(fenwickTree, map.get(nums[i]), 1);
        }
        return res;
    }

    private void updateBITree (int[] BITree, int index, int value) {
        for (int i = index + 1; i < BITree.length; i += (i & -i)) {
            BITree[i] += value;
        }
    }

    private int getSum (int[] BITree, int index) {
        int sum = 0;
        for (int i = index + 1; i > 0; i -= (i & -i)) {
            sum += BITree[i];
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] nums = {12,2};
        CountofSmallerNumbersAfterSelf test = new CountofSmallerNumbersAfterSelf();
        System.out.println(test.countSmaller(nums));
        System.out.println(test.countSmaller2(nums));

    }
}
