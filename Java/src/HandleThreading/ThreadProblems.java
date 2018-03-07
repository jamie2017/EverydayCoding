package HandleThreading;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Created by JMYE on 3/31/17.
 */
public class ThreadProblems {
    static double a = 10;
    static double b;

    public static void main(String[] args) { // result will change if run code several time
        Runnable r1 = () ->
        {
            if (a == 10) {
                try {
                    Thread.sleep(0);
                    b = a/2.0;
                    System.out.println(Thread.currentThread().getName() + ": " +a+", " + b);
                } catch (InterruptedException e) {}

            }
        };
        Runnable r2 = () -> {
            a = 12;
            System.out.println(Thread.currentThread().getName() + ": " + a+", " + b);
        };
        Thread thdA = new Thread(r1, "Thread A");
        Thread thdB = new Thread(r2, "Thread B");
        thdA.start();
        thdB.start();

    }

}
