package LinkedList;

/**
 * Created by JMYE on 9/25/16.
 */
public class ReverseLinkedList {
    // 1 -> 2 -> 3 -> 4 -> null
    // 2 -> 1 -> 3 -> 4 -> null
    // 3 -> 2 -> 1 -> 4 -> null
    // 4 -> 3 -> 2 -> 1 -> null


    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTmp;
        }
        return prev;
    }




    // recursion
    //
    // 1 -> (4 -> 3 -> 2 -> null)
    public ListNode reverseList_rec(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList_rec(head.next);
        head.next.next = head; // 2 -> 1
        head.next = null; // 1 -> null
        return newHead;  // 4 -> 3 -> 2 -> 1 -> null
    }
}
