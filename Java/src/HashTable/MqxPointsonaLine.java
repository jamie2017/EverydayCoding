package HashTable;

import java.util.HashMap;

/**
 * Created by JMYE on 9/13/16.
 */
public class MqxPointsonaLine {
    class Point {
        int x;
        int y;
        Point() {x = 0; y = 0;}
        Point(int a, int b) {
            x = a;
            y = b;
        }
    }


    private boolean inLine(Point a, Point b, Point c) {
        int k1, k2, b1, b2;
        k1 = (b.y - a.y) / (b.x - a.x);
        k2 = (c.y - b.y) / (c.x - b.x);
        b1 = (a.y * b.x - b.y * a.x) / (b.x - a.x);
        b2 = (b.y * c.x - c.y * b.x) / (c.x - b.x);
        if (k1 == k2 && b1 == b2) {
            return true;
        } else {
            return false;
        }
    }

    public  int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        HashMap<Double, Integer> map=new HashMap<Double, Integer>();
        int max = 1;

        for(int i = 0 ; i < points.length; i++) {
            // shared point changed, map should be cleared and server the new point
            map.clear();

            // maybe all points contained in the list are same points,and same points' k is
            // represented by Integer.MIN_VALUE
            map.put((double)Integer.MIN_VALUE, 1);

            int dup = 0;
            for(int j = i + 1; j < points.length; j++) {
                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                    dup++;
                    continue;
                }

                // look 0.0+(double)(points[j].y-points[i].y)/(double)(points[j].x-points[i].x)
                // because (double)0/-1 is -0.0, so we should use 0.0+-0.0=0.0 to solve 0.0 !=-0.0
                // problem

                // if the line through two points are parallel to y coordinator, then K(slop) is
                // Integer.MAX_VALUE
                double key=points[j].x - points[i].x == 0 ?
                        Integer.MAX_VALUE :
                        0.0 + (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);

                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 2);
                }
            }

            for (int temp: map.values()) {
                // duplicate may exist
                if (temp + dup > max) {
                    max = temp + dup;
                }
            }

        }
        return max;
    }
}
