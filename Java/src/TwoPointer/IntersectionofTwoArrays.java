package TwoPointer;

import java.util.*;

/**
 * Created by jianmei on 6/21/16.
 */
public class IntersectionofTwoArrays {
	/*
	Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
    */
	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1.length == 0 || nums2.length == 0) return new int[0];
		int n1 = nums1.length;
		int n2 = nums2.length;
		int [] result = new int [Math.min(n1, n2)];
		int i = 0;
		BitSet set = new BitSet();
		for (i = 0; i < n1; i++) {
			set.set(nums1[i]);
		}
		int count = 0;
		for (i = 0; i < n2; i++) {
			if (set.get(nums2[i])){
				result[count++] = nums2[i];
				set.set(nums2[i], false);
			}
		}
		return Arrays.copyOfRange(result, 0, count);
	}

	/*
	Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
	 */

//	What if the given array is already sorted? How would you optimize your algorithm?

	public int[] intersectII_S1(int[] nums1, int[] nums2) {
		if(nums1.length==0)
			return nums1;
		if(nums2.length==0)
			return nums2;
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i=0,j=0,k=0;
		while(i<nums1.length && j<nums2.length){
			if(nums1[i]<nums2[j] )
				i++;
			else if(nums2[j]<nums1[i])
				j++;
			else if(nums1[i]==nums2[j]){
				nums1[k++]=nums1[i];
				i++;
				j++;
			}
		}
		return Arrays.copyOfRange(nums1, 0, k);
	}

	//What if nums1's size is small compared to nums2's size? Which algorithm is better?
	public int[] intersectII_S2(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		Arrays.sort(nums2);
		for (Integer num : nums1) {
			if (binarySearch(nums2, num)) {
				set.add(num);
			}
		}
		int i = 0;
		int[] result = new int[set.size()];
		for (Integer num : set) {
			result[i++] = num;
		}
		return result;
	}

	public boolean binarySearch(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				return true;
			}
			if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return false;
	}
	//What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

	public int[] intersectII_S3(int[] nums1, int[] nums2) {// HashMap
		// Store the elements and frequency of all elements in nums1. Then iterate through nums2,
		// if that element exists in nums1 && its frequency is not 0,
		// decrease the frequency and add that element to the result array.
		// Time complexity is O(N) and space complexity is O(N)

		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return new int[0];
		}
		HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums1.length; i++) {
			if (count.containsKey(nums1[i])) {
				count.put(nums1[i], count.get(nums1[i]) + 1);
			} else {
				count.put(nums1[i], 1);
			}
		}
//		ArrayList<Integer> result = new ArrayList<Integer>();
		int [] result = new int [Math.min(nums1.length, nums2.length)];
		int idx = 0;
		for (int i = 0; i < nums2.length; i++) {
			if (count.containsKey(nums2[i]) && count.get(nums2[i]) > 0) {
				// result.add(nums2[i]);
				result[idx++] = nums2[i];
				count.put(nums2[i], count.get(nums2[i]) - 1);
			}
		}
// 		int[] res = new int[result.size()];
// 		for (int i = 0; i < result.size(); i++) {
// 			res[i] = result.get(i);
// 		}
		return Arrays.copyOfRange(result,0,idx);
	}



	public int[] intersection_ni(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
			return new int[0];
		}
		int len = nums1.length > nums2.length ? nums2.length : nums1.length;
		Set<Integer> set = new HashSet<>(len);
		int i = 0, j = 0;
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				set.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] < nums2[j]) {
				i++;
			} else {
				j++;
			}
		}
		int[] rst = new int[set.size()];
		int count = 0;
		for (Integer s: set) {
			rst[count++] = (int)s;
		}
		return rst;
	}

	public static void main (String[] argu) {
		int[] num1 = {1,2,2,4,5};
		int[] num2 = {2,2,5};
		IntersectionofTwoArrays test = new IntersectionofTwoArrays();
		for (int n :test.intersectII_S2(num1,num2)) {
			System.out.println(n);
		}

	}
}
