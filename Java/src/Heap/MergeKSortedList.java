package Heap;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by JMYE on 9/21/16.
 */
public class MergeKSortedList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }

    // Priority Queue

    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>(){
        public int compare(ListNode left, ListNode right) {
            if (left == null) {
                return 1;
            } else if (right == null) {
                return -1;
            }
            return left.val - right.val;
        }
    };
    public ListNode mergeKLists_pq(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, ListNodeComparator);
        for (int i = 0; i < lists.length; i++) {
            if(lists[i] != null) {
                heap.add(lists[i]);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!heap.isEmpty()) {
            ListNode head = heap.poll();
            tail.next = head;
            tail = head;
            if (head.next != null) {
                heap.add(head.next);
            }
        }
        return dummy.next;

    }

    // Solution 2 merge sort pairwise lists
    // Divide and conque
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }
        return mergeHelper(lists, 0, lists.size() - 1);
    }

    private ListNode mergeHelper(List<ListNode> lists, int start, int end) {
        if (start == end) {
            return lists.get(start);
        }

        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                tail = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                tail = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        return dummy.next;
    }
}
