package LinkedList;

/**
 * Created by JMYE on 9/18/16.
 */
public class PlusOneLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }

    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lastNotNine = dummy, node = head;

        while (node != null) {
            if (node.val != 9) {
                lastNotNine = node;
            }
            node = node.next;
        }
        lastNotNine.val++;
        node = lastNotNine.next;
        while (node != null) {
            node.val = 0;
            node = node.next;
        }
        return dummy.val == 1 ? dummy : dummy.next;
    }
}
