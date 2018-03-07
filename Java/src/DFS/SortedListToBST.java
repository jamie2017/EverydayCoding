package DFS;

/**
 * Created by JMYE on 9/22/16.
 */
public class SortedListToBST {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return sortedListToBST(head,null);
    }
    private TreeNode sortedListToBST(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == tail) return null;

        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head,slow);
        root.right = sortedListToBST(slow.next, tail);
        return root;
    }
}
