package HashTable;

import java.util.HashSet;

/**
 * Created by JMYE on 5/8/17.
 */
public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        HashSet<Integer> uniqueKinds = new HashSet<>();
        for(int c: candies) {
            uniqueKinds.add(c);
        }

        return Math.min(candies.length / 2, uniqueKinds.size());
    }
}
