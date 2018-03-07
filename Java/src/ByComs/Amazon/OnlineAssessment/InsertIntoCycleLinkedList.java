package ByComs.Amazon.OnlineAssessment;

/**
 * Created by JMYE on 10/10/16.
 */
public class InsertIntoCycleLinkedList {
    public ListNode LinkedListInsert(ListNode head, int val) {
        if (head == null) {
            ListNode rst = new ListNode(val);
            rst.next = rst;
            return rst;
        }

        ListNode cur = head;

        do {
            if (val <= cur.next.val && val >= cur.val) break;

            if (cur.val > cur.next.val && (val < cur.next.val || val > cur.val)) break;

            cur = cur.next;
        } while (cur != head);

        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next = newNode;
        return newNode;

    }
}
