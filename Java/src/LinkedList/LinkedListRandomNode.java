package LinkedList;

import java.util.Random;

/**
 * Created by JMYE on 9/18/16.
 */
public class LinkedListRandomNode {
    // http://blog.jobbole.com/42550/
    /*

    假设当前正要读取第n个数据，
    则我们以1/n的概率留下该数据，
    否则留下前n-1个数据中的一个。
    以这种方法选择，所有数据流中数据被选择的概率一样。
    简短的证明：假设n-1时候成立，
    即前n-1个数据被返回的概率都是1/n-1,
    当前正在读取第n个数据，以1/n的概率返回它。
    那么前n-1个数据中数据被返回的概率为：
    (1/(n-1))*((n-1)/n)= 1/n，假设成立。
     */
    ListNode head;
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
    }


    public int getRandom() {
        Random rand = new Random();
        int count = 0;
        ListNode node = head;
        ListNode candidate = head;
        while (true) {
            if (node == null) break;
            // nextInt(n) random integer between (0,n), n exclusive
            if (rand.nextInt(count + 1) == count) candidate = node;
            node = node.next;
            count++;
        }
        return candidate.val;
    }

    public static void main(String[] argu) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        LinkedListRandomNode test = new LinkedListRandomNode(head);
        int getOne = 0, getTwo = 0, getThree = 0;
        int trial = 10000 - 1;
        for (int i = 0; i < trial;i++) {
            if (test.getRandom() == 1) getOne++;
            else if (test.getRandom() == 2) getTwo++;
            else getThree++;
        }
        System.out.println("get1: " + getOne);
        System.out.println("get2: " + getTwo);
        System.out.println("get3: " + getThree);

    }
}
