package DesignPattern;

/**
 * Created by JMYE on 5/16/17.
 * 在饿汉式单例模式中，在类被加载时，静态变量mInstance就会被初始化。这时候，单例类的唯一实例就被创建出来了。
 */
public class EagerSingleton {
    private static final EagerSingleton mInstance = new EagerSingleton();

    private EagerSingleton() {}

    public static EagerSingleton getInstance() {
        return mInstance;
    }
    public void doSomething() {
        System.out.println(Thread.currentThread().getName()+" do something");
    }
}
