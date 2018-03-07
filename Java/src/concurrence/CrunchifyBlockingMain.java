package concurrence;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
/**
 * Created by JMYE on 5/10/17.
 *
 */
public class CrunchifyBlockingMain {
    public static void main(String[] args) {
        // Creating BlockingQueue of size 10
        // BlockingQueue supports operations that wait for the queue to become non-empty when retrieving an element, and
        // wait for space to become available in the queue when storing an element.
        BlockingQueue<CrunchifyMessage> crunchQueue = new ArrayBlockingQueue<>(5);//LinkedBlockingDeque
        CrunchifyBlockingProducer crunchProducer = new CrunchifyBlockingProducer(crunchQueue);
        CrunchifyBlockingConsumer crunchConsumer = new CrunchifyBlockingConsumer(crunchQueue);

        // starting producer to produce messages in queue
        new Thread(crunchProducer).start();

        // starting consumer to consume messages from queue
        new Thread(crunchConsumer).start();
        System.out.println("Let's get started. Producer / Consumer Test Started.\n");
    }
}
