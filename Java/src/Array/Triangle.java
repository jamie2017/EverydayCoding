package Array;

import java.util.List;

/**
 * Created by JMYE on 9/12/16.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) { // MARK SMART!
        if (triangle == null || triangle.size() == 0) {
            return -1;
        }
        for (int i = triangle.size() -2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle.get(i).set(j, triangle.get(i).get(j) +Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
