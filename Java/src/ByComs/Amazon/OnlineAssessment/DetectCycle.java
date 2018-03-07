package ByComs.Amazon.OnlineAssessment;

/**
 * Created by JMYE on 10/10/16.
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                ListNode newNode = head;
                while (newNode != slow) {
                    newNode = newNode.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
