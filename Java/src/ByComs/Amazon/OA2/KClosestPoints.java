package ByComs.Amazon.OA2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by JMYE on 10/9/16.
 */
class CPoint {
    double x;
    double y;
    public CPoint(double a, double b) {
        x = a;
        y = b;
    }
}
public class KClosestPoints {
    public CPoint[] kClosestCPoints(CPoint[] arr,int k) {// O(nlogk)
        CPoint[] rst = new CPoint[k];
        CPoint center = new CPoint(0.0,0.0);
        Queue<CPoint> pq = new PriorityQueue<CPoint>(k,
                (a, b) -> (int) (getDistance(b, center) - getDistance(a,center)));

        for (int i = 0; i < arr.length; i++) { // O(nlogk)
            pq.offer(arr[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) { // O(k)
            rst[--k] = pq.poll();
        }
        return Arrays.copyOfRange(rst,k,rst.length);
    }

    private double getDistance(CPoint a, CPoint b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

    public CPoint[] getKCloeset(CPoint[] CPoints, int k) { // O(nlogn) O(1)
        if (CPoints == null || CPoints.length == 0) {
            return CPoints;
        }
        if (k < 0) {
            return null;
        }
        CPoint o = new CPoint(0.0,0.0);
        Arrays.sort(CPoints, (o1, o2) -> (int)(getDistance(o1,o) - getDistance(o2,o))); // O(nlogn)
        if (k >= CPoints.length) {
            return CPoints;
        }
        return Arrays.copyOfRange(CPoints,0,k);
    }

    private void printCloesetCPoint(CPoint[] CPoints) {
        for (CPoint p:CPoints) {
            System.out.println(p.x +" " +p.y);

        }
    }

    public static void main(String[] args) {
        KClosestPoints test = new KClosestPoints();
        CPoint[] CPoints = { new CPoint(5.5,5.5),new CPoint(2.2,2.2), new CPoint(3.3,3.3),new CPoint(4.4,4.4),  new CPoint(1.1,1.1)};
        int k = 3;
//        test.printCloesetCPoint(test.getKCloeset(CPoints,k));
//        System.out.println("============");
        test.printCloesetCPoint(test.kClosestCPoints(CPoints,k));

    }
}



/*
* 一个组织发现了外星人，要给他们通信。
* 我们的任务是给太空中的一些有可能有外星人的点发射信号。
* 但是由于天线质量差（真是奇怪的理由），只能给太空中的k 个点发射信号。
* 现在又已知一个点P，它的坐标是(0,0)，这个点周围最有可能有外星人。
* 好了，给你N个点， 找到这个N个点中离原点P最近的k个。
*/