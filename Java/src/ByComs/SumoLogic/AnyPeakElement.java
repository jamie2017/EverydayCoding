package ByComs.SumoLogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by JMYE on 6/16/17.
 * Find any one peak element from an unsorted array
 */
public class AnyPeakElement {
    public int findPeakElement(int[] nums) {
        // O(n)
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] < nums[i - 1]) {
//                return i - 1;
//            }
//        }
//        return nums.length - 1;


        // O(lgn)
        // {1,7,8,6,0,4,1,3}
        // {8,7,6,5,4,3,2,1}
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        if (l == 0 || l == nums.length - 1) {
            return -1;
        }
        return l;

    }

    public int findPeakElementRec(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }
    public int search(int[] nums, int l, int r) {
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            return search(nums, l, mid);
        return search(nums, mid + 1, r);
    }

    public  int[] findPeakElement2D(int[][] nums) {
        int m = nums.length;
        for (int i = 0; i < m; i++) {
            int j = findPeakElement(nums[i]);
            if (i - 1 >= 0 && i + 1 <= m) {
                if (nums[i - 1][j] < nums[i][j] && nums[i][j] > nums[i + 1][j]) {
                    return new int[] {i,j};
                }
            } else if (i - 1 >= 0) {
                if (nums[i - 1][j] < nums[i][j]) {
                    return new int[] {i,j};
                }
            } else if (i + 1 <= m) {
                if (nums[i + 1][j] < nums[i][j]) {
                    return new int[] {i,j};
                }
            }
        }
        return new int[2];
    }

    public List<Integer> findPeakII(int[][] A) {
        // this is the nlog(n) method
        int low = 1, high = A.length-2;
        List<Integer> ans = new ArrayList<>();
        while(low <= high) {
            int mid = (low + high) / 2;
            int col = findColPeak(mid, A);
            if(A[mid][col] < A[mid - 1][col]) {
                high = mid - 1; //  \mid
            } else if(A[mid][col] < A[mid + 1][col]) {
                low = mid + 1; // mid/
            } else {
                ans.add(mid);
                ans.add(col);
                break;
            }
        }
        return ans;
    }
    int findColPeak(int row, int [][]A) {
        int col = 0;
        for(int i = 0; i < A[row].length; i++) {
            if(A[row][i] > A[row][col]) {
                col = i;
            }
        }
        return col;
    }


    public static void main(String[] args) {
        AnyPeakElement test = new AnyPeakElement();
        int[][] nums = {{1,4,2,5,1},{3,2,1,6,4},{0,3,2,0}};
        int[] rst = test.findPeakElement2D(nums);
        System.out.println(rst[0]);
        System.out.println(rst[1]);
        List<Integer> rst2 = test.findPeakII(nums);
        System.out.println(rst2);

        int[][] nums2 = {{1,2,3,4,5,6},{1,2,3,4,5,6}};
        System.out.println(test.findPeakII(nums2));


        int[] nums3 = {1,2,3,4,5,6};
        System.out.println(Arrays.asList(test.findPeakElement(nums3)));

    }
}


/*


// O(m + n) 算法
class Solution {
public List<Integer> find(int x1, int x2, int y1, int y2,
                          int[][] A, boolean flag) {

    if (flag) {
        int mid = x1 + (x2 - x1) / 2;
        int index = y1;
        for (int i = y1; i <= y2; ++i)
            if (A[mid][i] > A[mid][index])
                index = i;

        if (A[mid - 1][index] > A[mid][index])
            return find(x1, mid - 1, y1, y2, A, !flag);
        else if (A[mid + 1][index] > A[mid][index])
            return find(mid + 1, x2, y1, y2, A, !flag);
        else
            return new ArrayList<Integer>(Arrays.asList(mid, index));
    } else {
        int mid = y1 + (y2 - y1) / 2;
        int index = x1;
        for (int i = x1; i <= x2; ++i)
            if (A[i][mid] > A[index][mid])
                index = i;

        if (A[index][mid - 1] > A[index][mid])
            return find(x1, x2, y1, mid - 1, A, !flag);
        else if (A[index][mid + 1] > A[index][mid])
            return find(x1, x2, mid + 1, y2, A, !flag);
        else
            return new ArrayList<Integer>(Arrays.asList(index, mid));
    }
}
    public List<Integer> findPeakII(int[][] A) {
        // write your code here
        int n = A.length;
        int m = A[0].length;
        return find(1, n - 2, 1, m - 2, A, true);
    }
}

 */
