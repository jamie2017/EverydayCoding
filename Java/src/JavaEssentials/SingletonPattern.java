package JavaEssentials;

/**
 * Created by JMYE on 3/15/17.
 * 特点： 返回同一个引用；自己初始化自己；有一个获得instance
 * 优点：全局
 * 使用场景：回收站；计数器；鼠标
 */
public class SingletonPattern {
    private SingletonPattern() {}
    public String str;
    private static SingletonPattern instance = null;
    public static SingletonPattern getSingleInstance() {
        if (instance == null) {
            instance = new SingletonPattern();
        }
        return instance;
    }
}


class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance = null;
    private static Object mutex = new Object();
    private ThreadSafeSingleton() {

    }

    public static ThreadSafeSingleton getInstance(){
        if (instance == null) {
            synchronized(mutex) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}