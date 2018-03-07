package Design;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JMYE on 8/16/16.
 */
public class Logger {
    /** Initialize your data structure here. */
    private Map<String, Integer> logMap ;
    public Logger() {
        logMap = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (timestamp < logMap.getOrDefault(message,0)) {
            return false;
        }
        logMap.put(message, timestamp + 10);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */