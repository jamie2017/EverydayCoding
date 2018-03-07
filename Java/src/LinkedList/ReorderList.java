package LinkedList;

/**
 * Created by JMYE on 9/25/16.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null) return;

        //Find the middle of the list
        ListNode p1=head;
        ListNode p2=head;
        while(p2.next!=null&&p2.next.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }

        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode preMiddle=p1;
        ListNode preCurrent=p1.next;
        while(preCurrent.next!=null){
            ListNode current=preCurrent.next;
            preCurrent.next=current.next;
            current.next=preMiddle.next;
            preMiddle.next=current;
        }

        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        p1 = head; // 1
        p2 = preMiddle.next; // 6
        while(p1 != preMiddle){
            preMiddle.next = p2.next; // preMiddle is 3 now, preMiddle.next -> 5
            p2.next = p1.next; // 6 ->  2
            p1.next = p2; // 1 -> 6 -> 2 -> 3 -> 5 -> 4
            p1 = p2.next; // p1 = 2
            p2 = preMiddle.next; // p2 = 5
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ReorderList test = new ReorderList();
        test.reorderList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
