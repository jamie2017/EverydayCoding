package ByComs.Google;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by jianmei on 7/1/16.
 */
public class MovingAveragefromDataStream {
	Deque<Integer> dq;
	int size;
	int sum;
	/** Initialize your data structure here. */
	public MovingAveragefromDataStream(int size) {
		dq = new LinkedList<>();
		this.size = size;
		this.sum = 0;
	}

	public double next(int val) {
		if (dq.size() < size) {
			sum += val;
			dq.addLast(val);
			return (double)(sum*1.0 / dq.size());
		} else {
			int tmp = dq.pollFirst();
			sum -= tmp;
			dq.addLast(val);
			sum += val;
			return (double) (sum*1.0 /size);
		}

	}
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
