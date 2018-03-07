package ByComs.Facebook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JMYE on 8/22/17.
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] taskMap = new int[26];
        for(char task: tasks) {
            taskMap[task - 'A'] ++;
        }
        Arrays.sort(taskMap);
        int maxTaskCnt = taskMap[25] - 1;
        int idleSlots = maxTaskCnt * n;
        for (int i = 24; i >= 0 && taskMap[i] > 0; i--) {
            idleSlots -= Math.min(taskMap[i],maxTaskCnt); // !! need to min,because last task don't count
        }
        return idleSlots > 0? idleSlots + tasks.length: tasks.length;
    }
}
