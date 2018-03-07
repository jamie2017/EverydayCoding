package TwoPointer;

/**
 * Created by JMYE on 9/5/16.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = getLength(head);
        k = k % length;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode dummyTail = dummy;
        while (k > 0) {
            head = head.next;
            k--;
        }
        while(head.next != null) {
            dummyTail = dummyTail.next;
            head = head.next;
        }
        head.next = dummy.next;
        ListNode newHead = dummyTail.next;
        dummyTail.next = null;
        return newHead;


    }
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length ++;
            head = head.next;
        }
        return length;
    }
}
