package Heap;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by jianmei on 5/28/16.
 */
public class MedianFinder {

	private Queue<Long> maxHeap = new PriorityQueue(),
	                    minHeap = new PriorityQueue();

	// Adds a number into the data structure.
    public void addNum(int num) {
    	maxHeap.add((long) num);
    	minHeap.add(-maxHeap.poll());
    	if (maxHeap.size() < minHeap.size()) {
    		maxHeap.add(-minHeap.poll());
    	}
    }

    // Returns the median of current data stream
    public double findMedian() {
    	return maxHeap.size() > minHeap.size() ? maxHeap.peek() : (maxHeap.peek() - minHeap.peek()) / 2.0;  
    }
    
    public static void main (String[] argu) {
    	MedianFinder MF = new MedianFinder();
    	MF.addNum(1);
    	MF.addNum(2);
    	MF.addNum(3);
    	MF.addNum(10);
    	MF.addNum(5);
    	MF.addNum(23);
    	System.out.println(MF.findMedian());
    	
    }

}


// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();

