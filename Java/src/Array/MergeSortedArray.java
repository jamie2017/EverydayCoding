package Array;

/**
 * Created by jianmei on 6/11/16.
 */
public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int mn = m + n ;
		while (m > 0  && n > 0) {
			if (nums1[m - 1] >= nums2[n - 1]) {
				nums1[mn - 1] = nums1[m - 1];
				m --;
			} else {
				nums1[mn - 1] = nums2[n - 1];
				n --;
			}
			mn --;
		}
		while (m > 0) {
			nums1[mn-1] = nums1[m-1];
			mn --;
			m --;
		}
		while (n > 0) {
			nums1[mn-1] = nums2[n-1];
			mn --;
			n --;
		}
	}
}
