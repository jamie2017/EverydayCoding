package Design;

import java.util.*;

/**
 * Created by JMYE on 9/16/16.
 */
public class RandomizedCollection {
    List<Integer> nums;
    Map<Integer, Set<Integer>> map;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();

    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean ifContain = map.containsKey(val);
        if (!ifContain) {
            map.put(val, new LinkedHashSet<>());
        }
        map.get(val).add(nums.size());
        nums.add(val);
        return !ifContain;

    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean ifContain = map.containsKey(val);
        if (!ifContain) {
            return false;
        }
        int firstLoc = map.get(val).iterator().next();
        map.get(val).remove(firstLoc);
        if (firstLoc < nums.size() - 1) {
            int lastOne = nums.get(nums.size() - 1);
            nums.set(firstLoc, lastOne);
            map.get(lastOne).remove(nums.size() - 1);
            map.get(lastOne).add(firstLoc);
        }
        nums.remove(nums.size() - 1);

        if (map.get(val).isEmpty()) map.remove(val);
        return true;

    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));

    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
