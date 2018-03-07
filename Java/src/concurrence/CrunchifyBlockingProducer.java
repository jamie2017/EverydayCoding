package concurrence;
import java.util.concurrent.BlockingQueue;
/**
 * Created by JMYE on 5/10/17.
 */
public class CrunchifyBlockingProducer  implements Runnable{
    private BlockingQueue<CrunchifyMessage> crunchQueue;

    public CrunchifyBlockingProducer(BlockingQueue<CrunchifyMessage> queue) {
        this.crunchQueue = queue;
    }

    @Override
    public void run(){
        // producing CrunchifyMessage messages
        for (int i = 1; i <= 5; i++) {
            CrunchifyMessage msg = new CrunchifyMessage("I'm msg " + i);
            try{
                Thread.sleep(10);
                crunchQueue.put(msg);
                System.out.println("CrunchifyBlockingProducer: Message - " + msg.getMsg() + " produced.");
            } catch (Exception e) {
                System.out.println("Exception" + e);
            }
        }

        CrunchifyMessage msg = new CrunchifyMessage("All done from Producer side. Produced 5 CrunchifyMessages");
        CrunchifyMessage exit = new CrunchifyMessage("exit");
        try {
            crunchQueue.put(msg);
            crunchQueue.put(exit);
            System.out.println("CrunchifyBlockingProducer: Exit Message - " + exit.getMsg());

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
