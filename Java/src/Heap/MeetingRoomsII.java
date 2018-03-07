package Heap;



import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by JMYE on 9/29/16.
 */
public class MeetingRoomsII {

    public class Interval {
        int start;
        int end;
        Interval(){start = 0; end = 0;}
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Sort the intervals by start time
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        }) ;

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        heap.offer(intervals[0].end);
        for (int i = 1; i < intervals.length;i++) {
            if (intervals[i].start >= heap.peek()) {// no overlap means same room can reuse
                heap.poll();
            }
            heap.offer(intervals[i].end);
        }
        return heap.size();

    }


    /*

    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> (a.start - b.start));
        int max = 0;
        PriorityQueue<Interval> queue = new PriorityQueue<>(intervals.length, (a, b) -> (a.end - b.end));
        for(int i = 0; i < intervals.length; i++){
            while(!queue.isEmpty() && intervals[i].start >= queue.peek().end)
                queue.poll();
            queue.offer(intervals[i]);
            max = Math.max(max, queue.size());
        }
        return max;
    }
     */
}

