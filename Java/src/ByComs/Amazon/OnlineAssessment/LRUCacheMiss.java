package ByComs.Amazon.OnlineAssessment;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by JMYE on 10/10/16.
 */
public class LRUCacheMiss {
    public int countMiss(int[] array, int size) {
        if (array == null)  return 0;
        List<Integer> cache = new LinkedList<Integer>();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            Integer x = new Integer((array[i]));
            if (cache.contains(x)) {
                cache.remove(x);
                // It will remove x from the linkedlist
                // but object x is still alive in your code and usable anywhere else.
            }
            else {
                count++;
                if (size == cache.size())
                    cache.remove(0);
            }
            cache.add(x);
        }
//        System.out.println(cache);
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,2,2,3,2,1,4,3,2,5,4,3};
        int size = 2;
        LRUCacheMiss test = new LRUCacheMiss();
        System.out.println(test.countMiss(arr,size));
    }
}
