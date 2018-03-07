package Sort;

import java.util.Arrays;

/**
 * Created by JMYE on 11/4/16.
 */
public class EraseOverlapIntervals {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public int eraseOverlapIntervals(Interval[] intervals) {
        int count = 0;
        if (intervals == null || intervals.length <= 1) return count;
        Arrays.sort(intervals, (x, y) -> x.start - y.start);
        int rangeStart = intervals[0].start, rangeEnd = intervals[0].end;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start == rangeStart) {
                rangeEnd = Math.min(rangeEnd, intervals[i].end);
                count ++;
            }
            else if (intervals[i].start < rangeEnd) {
                if(intervals[i].end < rangeEnd) {
                    rangeEnd = intervals[i].end;
                    rangeStart = intervals[i].start;
                }
                count++;
            } else {
                rangeEnd = intervals[i].end;
            }
        }
        return count;
    }
}
