package LinkedList;

/**
 * Created by JMYE on 10/1/16.
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        ListNode newHead = head;
        while(newHead != slow) {
            newHead = newHead.next;
            slow = slow.next;
        }
        return newHead;
    }
}
