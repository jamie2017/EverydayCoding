
package Array;
// Remove duplicate from sorted array
// In place, O(n)
public class RemoveDuplicatefromSortedArray {
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
        	if (nums[i] != nums[j]) {
        		i ++;
        		nums[i] = nums[j];
        	}
        }
        return i + 1;
    }

    public static void main (String[] argu) {
    	RemoveDuplicatefromSortedArray test = new RemoveDuplicatefromSortedArray();
    	int[] nums = {1,2,3,3,3,3,3,4,5};
    	System.out.println(test.removeDuplicates(nums));
    }

}