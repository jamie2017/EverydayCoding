package Sort;

/**
 * Created by jianmei on 7/6/16.
 */
public class sortColors {
	public void sortColors(int[] nums) {
		if (nums == null || nums.length < 2) return;
		int low = 0, high = nums.length - 1;
		int i = 0;
		while(i <= high) {
			if(nums[i] == 0) {
				swap(nums,low, i);
				low++;
				i++;
			} else if (nums[i] == 1) {
				i++;
			} else {
				swap(nums,high,i);
				high--;
			}
		}

//         //// solution 2
//         int i = 0, j = 0;
//         for (int k = 0; k < nums.length; k++) {
//             int v = nums[k];
//             nums[k] = 2;
//             if (v < 2) {
//                 nums[j] = 1;
//                 j ++;
//             }
//             if (v == 0) {
//                 nums[i] = 0;
//                 i++;
//             }
//         }
	}

	private void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

}
