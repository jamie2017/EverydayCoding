package HandleThreading;

/**
 * Created by JMYE on 3/31/17.
 */
public class CountDown {
    public void printCount() {
        try {
            for (int i = 10; i > 0; i--) {
                System.out.println(" ---  " + i);
            }
            System.out.println("BlastOff!");
        } catch (Exception e) {
            System.out.println("Thread interrupted.");
        }
    }

    public static void main(String[] args) {
        CountDown cd = new CountDown();
        Runnable r = () -> {
             synchronized(cd) {
            cd.printCount();
        }
        };

        Thread one = new Thread(r, "one");
        Thread two = new Thread(r, "two");
        one.start();
        two.start();

    }
}
