package ByComs.Google;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jianmei on 7/2/16.
 */

public class LoggerRateLimiter {
	ConcurrentHashMap<String, Integer> map;

	/** Initialize your data structure here. */
	public LoggerRateLimiter() {
		map = new ConcurrentHashMap<>();

	}

	/** Returns true if the message should be printed in the given timestamp, otherwise returns false.
	 If this method returns false, the message will not be printed.
	 The timestamp is in seconds granularity. */
	public boolean shouldPrintMessage(int timestamp, String message) {
		if (map.containsKey(message) && (timestamp - map.get(message) < 10)){
			return false;
		}
		map.put(message, timestamp);
		return true;

	}
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new LoggerRateLimiter();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */