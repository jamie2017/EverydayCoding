package Stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by JMYE on 7/20/17.
 * 636. Exclusive Time of Functions
 */
public class ExclusiveTimeofFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] exeTimes = new int[n];
        Stack<Integer> stk = new Stack<>();
        int prevTime = 0;
        for (String log: logs) {
            String[] parts = log.split(":");
            int curId = Integer.parseInt(parts[0]);
            String curFun = parts[1];
            int curTime = Integer.parseInt(parts[2]);

            if (curFun.equals("start")) {
                if (!stk.isEmpty()) {
                    exeTimes[stk.peek()] += curTime - prevTime;
                }
                prevTime = curTime;
                stk.push(curId);
            } else {
                exeTimes[stk.pop()] += curTime - prevTime + 1;
                prevTime = curTime + 1;
            }
        }
        return exeTimes;
    }
    public static void main(String[] args) {
        ExclusiveTimeofFunctions test = new ExclusiveTimeofFunctions();
        int n = 2;
        List<String> logs = Arrays.asList("0:start:0",
                                              "1:start:2",
                                              "1:end:5",
                                              "0:end:6");
        int[] ans = test.exclusiveTime(n,logs);
        System.out.println(ans[0]+", " +ans[1]);
    }
}
