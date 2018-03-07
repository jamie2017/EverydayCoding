package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 9/15/16.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main (String[] argu) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        Permutations test = new Permutations();
        System.out.println(test.permute(nums));



    }
}
