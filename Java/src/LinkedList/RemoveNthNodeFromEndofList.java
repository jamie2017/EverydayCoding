package LinkedList;

import java.util.List;

/**
 * Created by jianmei on 6/21/16.
 */
public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd_rec(ListNode head, int n) {
		int r = remove(head, n);
		if (r == -1) return head;
		else return head.next;
	}

	int remove(ListNode node, int n) {
		if(node.next == null) return 0;
		else {
			int d = remove(node.next, n);
			if (d == -1) return -1;
			else {
				int c = 1 + d;
				if (c == n) {
					if(node.next.next == null) {
						node.next = null;
					} else {
						node.next = node.next.next;
					}
					return -1;
				}
				return c;
			}
		}
	}


	public ListNode removeNthFromEnd (ListNode head, int n) {
		if (n <= 0) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode preDelete = dummy;
		for (int i = 0; i < n; i++) {
			if (head == null) {
				return null;
			}
			head = head.next;
		}
		while (head != null) {
			head = head.next;
			preDelete = preDelete.next;
		}

		preDelete.next = preDelete.next.next;
		return dummy.next;
	}
}
