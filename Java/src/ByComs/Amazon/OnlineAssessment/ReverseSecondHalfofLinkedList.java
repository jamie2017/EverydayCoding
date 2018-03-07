package ByComs.Amazon.OnlineAssessment;

/**
 * Created by JMYE on 10/9/16.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class ReverseSecondHalfofLinkedList {


    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode prev = null;
        ListNode cur = slow.next ;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        slow.next = prev;
        return dummy.next;
    }


    public  ListNode reverseSecondHalfList(ListNode head) {
        if (head == null || head.next == null)      return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode pre = slow.next;
        ListNode cur = pre.next;
        while (cur != null) {
            pre.next = cur.next;
            cur.next = slow.next;
            slow.next = cur;
            cur = pre.next;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
//        head.next.next.next.next.next.next.next = new ListNode(8);

        ReverseSecondHalfofLinkedList test = new ReverseSecondHalfofLinkedList();
        ListNode rst = test.reverseList(head);
        while (rst != null) {
            System.out.println(rst.val);
            rst = rst.next;
        }
    }

}
