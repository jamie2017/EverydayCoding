package Array;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by JMYE on 9/13/16.
 */
public class MergeIntervals {
    public class Interval {
        int start;
        int end;
        Interval() {start = 0; end = 0;}
        Interval(int s, int e) { start = s; end = e;}
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        Collections.sort(intervals, new IntervalComparator());
        List<Interval> rst = new ArrayList<>();
        Interval previous = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curt = intervals.get(i);
            if (curt.start <= previous.end) {
                previous.end = Math.max(previous.end, curt.end);
            } else {
                rst.add(previous);
                previous = curt;
            }
        }
        rst.add(previous);
        return rst;
    }


    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }





    /*

     def merge(self, intervals):
        intervals = sorted(intervals, key=lambda x: x.start)
        result = []
        for interval in intervals:
            if len(result) == 0 or result[-1].end < interval.start:
                result.append(interval)
            else:
                result[-1].end = max(result[-1].end, interval.end)
        return result
     */

}
