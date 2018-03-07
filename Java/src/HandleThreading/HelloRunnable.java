package HandleThreading;

/**
 * Created by JMYE on 3/31/17.
 */
public class HelloRunnable  implements Runnable{
    public void run() {
        System.out.println("Hello from " + Thread.currentThread().getName() + " "
                + "a thread created by "
                + "implementing a Runnable interface!");
    }
}
