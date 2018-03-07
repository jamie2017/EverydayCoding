package HandleThreading;

/**
 * Created by JMYE on 3/31/17.
 */
public class HelloThread extends Thread {
    public void run() {
        System.out.println("Hello from " + Thread.currentThread().getName()
                + " created by "
                + "extending Thread class!");
    }
}
