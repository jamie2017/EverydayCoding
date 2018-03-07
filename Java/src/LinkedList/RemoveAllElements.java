package LinkedList;

/**
 * Created by JMYE on 7/10/17.
 */
public class RemoveAllElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode toDel = dummy;
        while (toDel.next != null) {
            if (toDel.next.val == val) {
                toDel.next = toDel.next.next;
            } else {
                toDel = toDel.next;
            }
        }
        return dummy.next;
    }

    public ListNode removeElementsRec(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElementsRec(head.next,val);
        return head.val == val? head.next: head;
    }




}
