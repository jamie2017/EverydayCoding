package DesignPattern;

/**
 * Created by JMYE on 5/16/17.
 * 在懒汉式单例模式中，在类被加载时，静态变量mInstance并不会被初始化；而只有当getInstance()第1次被调用的时候，mInstance才被初始化。
 */
public class LazySingleton {
    private static LazySingleton mInstance = null;

    private LazySingleton() {}

    synchronized public static LazySingleton getInstance() {
        if (mInstance==null) {
            mInstance = new LazySingleton();
        }
        return mInstance;
    }
    public void doSomething() {
        System.out.println(Thread.currentThread().getName()+" do something");
    }
}

