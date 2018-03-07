package BinarySearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by JMYE on 11/4/16.
 */
public class FindRightInterval {
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static int[] findRightInterval(Interval[] intervals) {
        if (intervals == null || intervals.length < 1) return null;

        int[] rst = new int[intervals.length];

        if (rst.length == 1) {
            rst[0] = -1;
            return rst;
        }

        Map<Interval, Integer> map = new HashMap<>(); // space O(n)
        for (int i = 0; i < intervals.length; i++) { // O(n)
            map.put(intervals[i], i);
        }
        Arrays.sort(intervals, (x, y)->x.start - y.start); // O(nlogn)
        int index = 0;
        int L, R, M, target;
        while (index < intervals.length) {
            target = intervals[index].end;
            L = index + 1;
            R = intervals.length - 1;
            while(L < R) { // O(logn)
                M = L + (R - L) / 2;
                if (target <= intervals[M].start){
                    R = M;
                } else {
                    L = M + 1;
                }
            }
            L = Math.min(L, intervals.length - 1);
            if (intervals[L].start >= target) {
                rst[map.get(intervals[index])] = map.get(intervals[L]);
            } else {
                rst[map.get(intervals[index])] = -1;
            }
            index++;
        }
        return rst;
    }


    public static int[] findRightInterval_tree(Interval[] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] res = new int[intervals.length];
        for(int i=0;i<intervals.length;i++) map.put(intervals[i].start, i);
        for(int i=0;i<intervals.length;i++) {
            Integer key = map.ceilingKey(intervals[i].end);
            res[i] = key!=null ?map.get(key) : -1;
        }
        return res;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(1,4);
        intervals[1] = new Interval(2,3);
        intervals[2] = new Interval(3,4);
        int[] rst = findRightInterval(intervals);
        for (int r : rst) {
            System.out.println(r);
        }
    }
}
