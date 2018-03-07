package ByComs.Amazon.OnlineAssessment;

/**
 * Created by JMYE on 10/9/16.
 */
public class Merge2SortedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), cur = dummy;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

}
