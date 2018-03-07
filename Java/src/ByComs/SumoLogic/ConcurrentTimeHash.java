package ByComs.SumoLogic;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by JMYE on 6/28/17.
 * 设计一个cocurrent环境下的time leased cache，但是有些
 区别，假如delete操作是一个daemon thread来做不用太多考虑，但是get(key)操作的
 逻辑是如果key不在cache里面，需要一个非常expensive的操作把对应value load进来
 ，如何让这个load的操作对同一个key尽量少发生，需要写代码实现。
 */



public class ConcurrentTimeHash<Key, Timestamp, Value> {
    private HashMap<Key, TreeMap<Timestamp, Value>> CACHE = new HashMap<>();

    public Value get(Key key, Timestamp ts) {
        final TreeMap<Timestamp, Value> treeMap = CACHE.get(key);
        if (treeMap == null) {
            synchronized (CACHE) {
                if (!CACHE.containsKey(key)) {
                    CACHE.put(key, new TreeMap<>());
                }
            }
            System.out.println(">>>> "+CACHE.keySet().toString());
            return null;
        }
        final Timestamp floorKey = treeMap.floorKey(ts);
        return floorKey == null? null: treeMap.get(floorKey);
    }

    public void put(Key key, Timestamp ts, Value value) {
        if (!CACHE.containsKey(key)) {
            synchronized (CACHE) {
                if (!CACHE.containsKey(key)) {
                    CACHE.put(key, new TreeMap<>());
                }
            }
        }
        CACHE.get(key).put(ts,value);
    }


    public static void main(String[] args) {
        ConcurrentTimeHash<String, Double, String> data = new ConcurrentTimeHash<String, Double, String>();

        System.out.println(data.get("K",0.9));
        System.out.println(data.get("K",1.0));
        data.put("K",1.0,"K1");
        data.put("K",2.0,"K2");
        System.out.println(data.get("K",0.9));
        System.out.println(data.get("K",1.0));
        System.out.println(data.get("k1",0.4));
        data.put("k1",0.5,"k1.1");
        System.out.println(data.get("K",1.5));
        System.out.println(data.get("K",2.0));
        System.out.println(data.get("K",2.2));
        System.out.println(data.get("k1",0.4));


    }

}
