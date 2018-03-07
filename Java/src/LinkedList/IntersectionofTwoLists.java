package LinkedList;

/**
 * Created by JMYE on 10/1/16.
 */
public class IntersectionofTwoLists { // SMART!!!!!!
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) { // if no intersection, both a and b will reach null such that a == b == null, break loop
                         // Otherwise a and b will walk same distance, so that they will reach intersection at the same time
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
