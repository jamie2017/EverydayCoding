package HandleThreading;

/**
 * Created by JMYE on 3/31/17.
 */
class ID {
    private static int counter; // initialized to 0 by default

    public static synchronized int getIdSafe()
    {
        return counter++;
    }


}
public class ThreadCounter {
    static int counter = 1;

    public static void main(String[] args) {
//        Runnable r = () -> {
//            System.out.println("Id value: " +Thread.currentThread().getName() +" " + getId());
//        };
//        Thread one = new Thread(r, "one");
//        one.start();
//        Thread two = new Thread(r, "two");
//        two.start();
//        Thread three = new Thread(r, "three");
//        three.start();


        Runnable r2 = () -> {
            ID id = new ID();
            System.out.println("Id value: " +Thread.currentThread().getName() +" " + id.getIdSafe());
        };
        Thread one = new Thread(r2, "one");
        one.start();
        Thread two = new Thread(r2, "two");
        two.start();
        System.out.println(counter);
    }

    public static int getId() {
        return counter++;
    }

    // if try run many time, it will return error result such that
    //    Id value: two 1
    //    Id value: one 1


}
