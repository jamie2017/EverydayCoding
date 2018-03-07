package ByComs.SumoLogic;

//import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

/**
 * Created by JMYE on 6/23/17.
 * 中国大叔主面，很nice，年轻三哥
 shadoow。设计一个cache system，要pseduo code，存储结构，API等，不要求LRU等替
 换策略，需要考虑concurrent的情况。要求考虑真实的使用场景，也就是这个cache
 system码工们用起来很方便。
 */
public class ConcurrentCacheSystem {
    static Map<Integer, Integer> cache = new HashMap<>();
    static int fibonacci(int i){
        if (i == 0)
            return i;
        if (i == 1)
            return 1;
        return cache.computeIfAbsent(i, (key) -> {
            System.out.println(
                    "Slow calculation of " + key);
            return fibonacci(i - 2) + fibonacci(i - 1);
        });
    }

    public int fibonacciJava7(int i) {
        if (i == 0)
            return i;
        if (i == 1)
            return 1;
        Integer result = cache.get(i);
        if (result == null) {
            synchronized (cache) {
                result = cache.get(i);
                if (result == null) {
                    System.out.println(
                            "Slow calculation of " + i);
                    result = fibonacciJava7(i - 2) + fibonacciJava7(i - 1);
                    cache.put(i ,result);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++)
            System.out.println(
                    "f(" + i + ") = " + fibonacci(i));
//                    "f(" + i + ") = " + fibonacciJava7(i));

    }

//    @Test
//    public void test(){
//        ConcurrentCacheSystem test = new ConcurrentCacheSystem();
//        for (int i = 0; i < 10; i++) {
//            LOGGER.info("f(" + i + ")= " + test.fibonacciJava7(i));
//        }
//    }
}


/*
Java 8 implement local thread-safe cache


private static final ConcurrentMap<String, Object>
CACHE = new ConcurrentHashMap();
public Object get(String key) {
    return CACHE.computeIfAbsent(key, k - > createObject(k));
}

From ConcurrentHashMap javadoc
If the specified key is not already associated with a value, attempts to compute its value using the given mapping function and enters it into this map unless null.
The entire method invocation is performed atomically, so the function is applied at most once per key.

 */

/*
Java 7 Double-checked locking

public Object get(String key) {
    if (!CACHE.containsKey(key)) {
        synchronized (CACHE) {
            if (!CACHE.containsKey(key)) {
                CACHE.put(key, createObject(key));
            }
        }
    }
    return CACHE.get(key);
}


/*
ConcurrentMap

If object creating is a lightweight operation and creation of multiple objects per key is acceptable under rare conditions,
then putIfAbsent method can be used:

public Object get(String key) {
    Object object = CACHE.get(key);
    if (object == null) {
        final Object newObject = createObject(key);
        object = CACHE.putIfAbsent(key, newObject);
        if (object == null) {
            object = newObject;
        }
    }
    return object;
}
putIfAbsent javadoc.
When race condition occurs, the object created first will be returned and the one created second will be throwed away.
This is an optimistic locking pattern.

 */
