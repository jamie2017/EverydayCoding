package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by JMYE on 6/25/17.
 * 630. Course Schedule III
 */
public class CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b)->a[1]-b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);
        int startTime = 0;
        for (int[] c: courses) {
            startTime += c[0];
            pq.add(c[0]);
            if (startTime > c[1]) {
                startTime -= pq.poll();
            }
        }
        return pq.size();
    }
}
