package HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JMYE on 9/16/16.
 */
public class LineReflection {// reflection here means there's a line can separate all given points equally
    public boolean isReflected(int[][] points) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>();
        for (int[] p: points) {
            max = Math.max(max, p[0]);
            min = Math.min(min, p[0]);
            String str = p[0] + " " + p[1];
            set.add(str);
        }
        int sum = max + min;
        for (int[] p : points) {
            String str = (sum - p[0]) + " " + p[1];
            if (!set.contains(str)) {
                return false;
            }
        }
        return true;
    }

    /*

    def isReflected(self, points):
    if not points: return True
    X = min(points)[0] + max(points)[0]
    return {(x, y) for x, y in points} == {(X - x, y) for x, y in points}

    // shorter
    return set(map(tuple, points)) == {(X - x, y) for x, y in points}
     */
}
