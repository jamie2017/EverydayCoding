package Array;

import java.util.List;

/**
 * Created by JMYE on 9/12/16.
 */
public class InsertInterval {
    public class Interval {
        int start;
        int end;
        Interval() {start = 0; end = 0;}
        Interval(int s, int e) { start = s; end = e;}
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) i++;
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start), Math.max(intervals.get(i).end, newInterval.end));
            intervals.remove(i);
        }
        intervals.add(i,newInterval);
        return intervals;
    }

}
