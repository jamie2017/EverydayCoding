package BinarySearch;

import java.util.List;

/**
 * Created by JMYE on 8/14/17.
 */
public class FindKClosestElements {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        int low = 0, high = arr.size() - k;
        while (low < high) {
            int mid = (low + high)/2;
            if (x - arr.get(mid) > arr.get(mid + k) - x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return arr.subList(low,low + k);
    }
}
