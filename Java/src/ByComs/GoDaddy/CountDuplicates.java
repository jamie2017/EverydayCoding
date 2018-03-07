package ByComs.GoDaddy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JMYE on 9/29/16.
 */
public class CountDuplicates {

    static int countDuplicates(int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : numbers) {
            if (!map.containsKey(num)) {
                map.put(num,1);
            } else {
                map.put(num,map.get(num) + 1);
            }
        }
        int count = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) > 1){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        CountDuplicates test = new CountDuplicates();
        int[] n = {1,1,2,2,2,3};
        System.out.println(countDuplicates(n));
    }
}
