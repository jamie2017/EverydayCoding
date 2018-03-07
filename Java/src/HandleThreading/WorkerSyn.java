package HandleThreading;

import java.util.concurrent.CountDownLatch;

/**
 * Created by JMYE on 3/31/17.
 */

public class WorkerSyn extends Thread {
    private final CountDownLatch start;
    private final CountDownLatch end;
    WorkerSyn(CountDownLatch start, CountDownLatch end) {
        this.start = start;
        this.end = end;
    }
    public void run() {
        try
        {
            printInfo("thread entered run()");
            start.await();  // wait before proceeding
            printInfo("doing work");
            Thread.sleep(3000);
            end.countDown(); // reduce count
        }
        catch (InterruptedException ie)
        {
            System.err.println(ie);
        }
    }

    void printInfo(String s)
    {
        System.out.println(System.currentTimeMillis() +
                ": " + Thread.currentThread() +
                ": " + s);
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(4);
        // create and start threads
        for (int i = 0; i < 5; ++i)
            new Thread(new WorkerSyn(start,end)).start();

        try{
            System.out.println("main thread doing something");
            Thread.sleep(1000); // sleep for 1 second
            start.countDown(); // let all threads proceed
            System.out.println("main thread doing something else");
            end.await(); // wait for all threads to finish

        }
        catch (InterruptedException ie)
        {
            System.err.println(ie);
        }
    }
}