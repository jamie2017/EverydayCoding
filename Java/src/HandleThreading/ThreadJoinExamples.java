package HandleThreading;

/**
 * Created by JMYE on 3/31/17.
 */
public class ThreadJoinExamples {
    public static void main(String[] args) {
        TestJoinClass t1 = new TestJoinClass("t1");
        TestJoinClass t2 = new TestJoinClass("t2");
        TestJoinClass t3 = new TestJoinClass("t3");
        t1.start();
        t2.start();
        try {
            t2.join();
        } catch (Exception e) {
            System.out.println(e);
        }
        t3.start();

    }
}
