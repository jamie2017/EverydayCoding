package ByComs.SumoLogic;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * https://www.careercup.com/question?id=5689672300756992
 * Created by JMYE on 6/22/17.
 * 设计带历史记录的哈希表。对于同一个key下出现过的多个value都记录，每个value
 都加个timestamp。查找时get（key， ts），输出value，其时间戳是在ts或者ts之前
 最近的。
 */
public class TimeHashMap<Key, Timestamp, Value> {
    private HashMap<Key, TreeMap<Timestamp, Value>> map = new HashMap<>();

    public Value get(Key key, Timestamp ts) {
        TreeMap<Timestamp, Value> treeMap = map.get(key);
        if (treeMap == null) {
            return null;
        }
        Timestamp floorKey = treeMap.floorKey(ts);
        return floorKey == null? null: treeMap.get(floorKey);
    }

    public void put(Key key, Timestamp ts, Value value) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<>());
        }
        map.get(key).put(ts,value);
    }

    public static void main(String[] args) {
        TimeHashMap<String, Double, String> data = new TimeHashMap<String, Double, String>();
        data.put("K",1.0,"K1");
        data.put("K",2.0,"K2");
        System.out.println(data.get("K",0.9));
        System.out.println(data.get("K",1.0));
        System.out.println(data.get("K",1.5));
        System.out.println(data.get("K",2.0));
        System.out.println(data.get("K",2.2));
    }

}
