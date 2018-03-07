package Array;

import java.util.*;

/**
 * Created by JMYE on 8/25/16.
 */

public class IntersectionTwoArray {
    // 349. Intersection of Two Arrays
    // HashTable
    public int[] intersection1_Hash(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }
    // Sort two pointers
    public int[] intersection1_sort(int[] nums1, int[] nums2) {
        Set<Integer> interset = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                interset.add(nums1[i]);
                i++;
                j++;
            }
        }
        int interSize = interset.size();
        int[] result = new int[interSize];
        i = 0;
        for (Integer num: interset) {
            result[i++] = num;
        }
        return result;
    }
    // Binary search
    public int[] intersection1_binary_search(int nums1[], int nums2[]) {
        Set<Integer> interset = new HashSet<>();
        Arrays.sort(nums1);
        for (int num: nums2) {
            if (binarySearch(nums1,num)) {
                interset.add(num);
            }
        }
        int interSize = interset.size();
        int[] result = new int[interSize];
        int i = 0;
        for (Integer num: interset) {
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


    // 350. Intersection of Two Arrays II
//    What if the given array is already sorted? How would you optimize your algorithm?
    public int[] intersect2_sort(int[] nums1, int[] nums2) {
        List<Integer> interList = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                interList.add(nums1[i]);
                i++;
                j++;
            }
        }
        int interSize = interList.size();
        int[] result = new int[interSize];
        i = 0;
        for (Integer num: interList) {
            result[i++] = num;
        }
        return result;
    }

    //What if nums1's size is small compared to nums2's size? Which algorithm is better?
    public int[] intersect2_hash(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < nums1.length; i++)
        {
            if(map.containsKey(nums1[i])) map.put(nums1[i], map.get(nums1[i])+1);
            else map.put(nums1[i], 1);
        }

        for(int i = 0; i < nums2.length; i++)
        {
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0)
            {
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }

        int[] r = new int[result.size()];
        for(int i = 0; i < result.size(); i++)
        {
            r[i] = result.get(i);
        }

        return r;
    }

    // What if elements of nums2 are stored on disk,
    // and the memory is limited such that you cannot load all elements into the memory at once?
    // chunk separatly
}
