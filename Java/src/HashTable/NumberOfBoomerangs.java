package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JMYE on 11/22/16.
 */
public class NumberOfBoomerangs {
    // for each point, store the distance from all other points to it and group points with same distance.
    // as we only need the number, so we just store number instead of actually points.
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        int rst = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j)continue;
                int dist = getDistance(points[i], points[j]);
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }
            for (int val : map.values()) {
                rst += val * (val - 1);
            }
            map.clear();
        }

        return rst;
    }

    private int getDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return dx * dx + dy * dy;
    }

    public static void main(String[] args) {
        int[][] points = {{0,0},{1,0},{2,0}};
        NumberOfBoomerangs test = new NumberOfBoomerangs();
        System.out.println(test.numberOfBoomerangs(points));
    }
}
