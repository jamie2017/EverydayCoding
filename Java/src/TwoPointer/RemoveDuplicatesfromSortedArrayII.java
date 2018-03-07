package TwoPointer;

/**
 * Created by JMYE on 9/5/16.
 */
public class RemoveDuplicatesfromSortedArrayII { // MARK
    public int removeDuplicates(int[] nums) {
        if(nums == null)
            return 0;
        int cur = 0;
        int i ,j;
        for(i = 0; i < nums.length;){
            int now = nums[i];
            for( j = i; j < nums.length; j++){
                if(nums[j] != now)// smart
                    break;
                if(j-i < 2)
                    nums[cur++] = now;
            }
            i = j;
        }
        return cur;
    }
}
