package DesignPattern;

/**
 * Created by JMYE on 5/16/17.
 */
public class SingletonTest {
    public static void main(String[] args) {
        // 启动5个线程。它们会分别获取EagerSingleton实例，并调用它的doSomething()方法。
        for (int i=0; i<5; i++) {
            new Thread( new Runnable() {
                @Override
                public void run() {
                    EagerSingleton es = EagerSingleton.getInstance();
                    es.doSomething();
                }
            }).start();
        }
    }
}
