package Sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by jianmei on 7/6/16.
 */

// Definition for an interval.


public class canAttendMeetings {
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	public boolean canAttendMeetings(Interval[] intervals) {
		try {
			Arrays.sort(intervals, new IntervalComparator());
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval o1, Interval o2) {
			if (o1.start < o2.start && o1.end <= o2.start)
				return -1;
			else if (o1.start > o2.start && o1.start >= o2.end)
				return 1;
			throw new RuntimeException();
		}
	}


	public boolean canAttendMeetings_simple(Interval[] intervals) {
		// Sort the intervals by start time
		Arrays.sort(intervals, (x, y) -> x.start - y.start);
		for (int i = 1; i < intervals.length; i++)
			if (intervals[i-1].end > intervals[i].start)
				return false;
		return true;
	}
}
