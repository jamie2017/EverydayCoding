package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by JMYE on 8/15/16.
 */
public class SubsetII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null)
            return null;
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<List<Integer>> prev = new ArrayList<List<Integer>>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1 || nums[i] != nums[i + 1] || prev.size() == 0) {
                prev = new ArrayList<List<Integer>>();
                for (int j = 0; j < result.size(); j++) {
                    prev.add(new ArrayList<Integer>(result.get(j)));
                }
            }

            for (List<Integer> temp : prev) {
                temp.add(0, nums[i]);
            }

            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(nums[i]);
                prev.add(temp);
            }

            for (List<Integer> temp : prev) {
                result.add(new ArrayList<Integer>(temp));
            }
        }

        result.add(new ArrayList<Integer>());

        return result;
    }

    public List<List<Integer>> subsetsWithDupRecursive(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null) {
            return result;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        subsetsHelper(result,list,nums,0);
        return result;
    }
    private void subsetsHelper (List<List<Integer>> result, List<Integer> list, int[] nums, int pos) {
        result.add(new ArrayList<Integer>(list));
        for (int i = pos; i < nums.length; i++) {
            if (pos != i && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            subsetsHelper(result,list,nums,i + 1);
            list.remove(list.size() - 1);
        }
    }


    public static void main (String[] args) {
        int[] nums = {1,2,2};
        SubsetII test = new SubsetII();
        System.out.println(test.subsetsWithDupRecursive(nums));
    }

}
