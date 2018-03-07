package concurrence;

import java.util.concurrent.BlockingQueue;

/**
 * Created by JMYE on 5/10/17.
 */
public class CrunchifyBlockingConsumer implements Runnable {
    private BlockingQueue<CrunchifyMessage> queue;

    public CrunchifyBlockingConsumer(BlockingQueue<CrunchifyMessage> queue) {
        this.queue = queue;
    }

    @Override
    public void run(){
        try {
            CrunchifyMessage msg;
            // consuming messages until exit message is received
            while ((msg = queue.take()).getMsg() != "exit") {
                Thread.sleep(10);
                System.out.println("CrunchifyBlockingConsumer: Message - " + msg.getMsg() + " consumed.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
