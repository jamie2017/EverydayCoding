package LinkedList;

/**
 * Created by JMYE on 10/31/16.
 */
public class ReverseNodesInK_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while(curr != null && count != k) {
            curr = curr.next;
            count++;
        }

        if (k == count) {
            curr = reverseKGroup(curr, k);
            while(count -- > 0) {
                ListNode tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
            }
            head = curr;
        }
        return head;
    }

    public ListNode reverseKGroup_iter(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) return head;
        ListNode  dummy = new ListNode(0);
        dummy.next = head;

        ListNode tail = dummy, prev = dummy, tmp;
        int count;
        while(true) {
            count = k;
            while (count > 0 && tail != null) {
                count --;
                tail = tail.next;
            }
            if (tail == null) break;

            head = prev.next;
            while(prev.next != tail) {
                tmp = prev.next;
                prev.next = tmp.next;
                tmp.next = tail.next;
                tail.next = tmp;
            }
            tail = head;
            prev = head;
        }
        return dummy.next;
    }

}
