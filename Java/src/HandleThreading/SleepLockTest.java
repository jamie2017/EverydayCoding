package HandleThreading;

/**
 * Created by JMYE on 5/16/17.
 */
public class SleepLockTest{

    private static Object obj = new Object();

    public static void main(String[] args){
        ThreadSleep t1 = new ThreadSleep("t1");
        ThreadSleep t2 = new ThreadSleep("t2");
        t1.start();
        t2.start();
    }

    static class ThreadSleep extends Thread{
        public ThreadSleep(String name){
            super(name);
        }
        public void run(){
            // 获取obj对象的同步锁
            synchronized (obj) {
                try {
                    for(int i=0; i <10; i++){
                        System.out.printf("%s: %d\n", this.getName(), i);
                        // i能被4整除时，休眠100毫秒
                        if (i%4 == 0)
                            Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
