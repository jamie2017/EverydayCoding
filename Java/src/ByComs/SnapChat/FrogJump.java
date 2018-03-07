package ByComs.SnapChat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by JMYE on 11/3/16.
 */
public class FrogJump {
    public static boolean canCross(int[] stones) {
        // the most progressive arrange is [0, 1, 3, 6, 10, 15, 21, ...]
        // the right-most point is at most 0 + (1 + len - 1) * (len - 1) / 2
        if (stones == null || stones.length == 0 || stones[1] != 1
                || stones[stones.length - 1] > (stones.length * (stones.length - 1) / 2)) return false;

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < stones.length - 1; i++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(stones[0]).add(1);
        for (int i = 0; i < stones.length -1; i++) {
            int stone = stones[i];
            for (int step : map.get(stone)) {
                System.out.println(i + " " + step + " " + stone);
                int reach = step + stone;
                if (reach == stones[stones.length - 1]) {
                    return true;
                }
                Set<Integer> set = map.get(reach);
                if (set != null) {
                    set.add(step);
                    if (step - 1 > 0) set.add(step - 1);
                    set.add(step + 1);
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] stoens = {0,1,3,5,6,8,12,17};
        System.out.println(canCross(stoens));
    }
}
