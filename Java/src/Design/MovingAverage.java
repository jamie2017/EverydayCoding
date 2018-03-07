package Design;

import java.util.LinkedList;
import java.util.Queue;

// 346. Moving Average from Data Stream
public class MovingAverage {
    private double prevSum = 0.0;
    private int maxSize;
    private Queue<Integer> window;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        window = new LinkedList<Integer>();
        maxSize = size;
    }

    public double next(int val) {
        if (window.size() == maxSize) {
            prevSum -= window.remove();
        }
        prevSum += val;
        window.add(val);
        return prevSum / window.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */