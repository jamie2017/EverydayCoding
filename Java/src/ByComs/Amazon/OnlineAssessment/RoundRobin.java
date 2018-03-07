package ByComs.Amazon.OnlineAssessment;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by JMYE on 10/10/16.
 */

class Process {
    int arrTime;
    int exeTime;
    Process(int arr, int exe) {
        arrTime = arr;
        exeTime = exe;
    }
}
public class RoundRobin {
    public float RoundRobinScheduling (int[] Atime, int[] Etime, int q) {
        if (Atime == null || Etime == null || Atime.length != Etime.length) {
            return 0;
        }

        int len = Atime.length;
        Queue<Process> queue = new LinkedList<>();
        int curTime = 0, waitTime = 0;
        int index = 0;
        while (!queue.isEmpty() || index < len) {
            if (!queue.isEmpty()) {
                Process cur = queue.poll();
                waitTime += curTime - cur.arrTime;
                curTime += Math.min(cur.exeTime, q);
                for (; index < len && Atime[index] <= curTime; index++) {
                    queue.offer(new Process(Atime[index], Etime[index]));
                }
                if (cur.exeTime > q) {
                    queue.offer(new Process(curTime, cur.exeTime - q));
                }
            } else {
                queue.offer(new Process(Atime[index],Etime[index]));
                curTime = Atime[index++];
            }
        }
        return (float) waitTime / len;
    }


    public static void main (String[] args) {
        int[] Atime = {0,1,4};
        int[] Etime = {5,2,3};
        int q = 3;
        RoundRobin test = new RoundRobin();
        System.out.println(test.RoundRobinScheduling(Atime,Etime,q));
    }
}
