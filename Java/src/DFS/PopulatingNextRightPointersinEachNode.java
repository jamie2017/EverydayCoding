package DFS;

/**
 * Created by JMYE on 9/1/16.
 */
public class PopulatingNextRightPointersinEachNode {
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        TreeLinkNode cur = root;
        TreeLinkNode nextLeftmost = null;
        while (cur.left != null) {
            nextLeftmost = cur.left;
            while (cur != null) {
                cur.left.next = cur.right;
                cur.right.next = cur.next == null ? null: cur.next.left;
                cur = cur.next;
            }
            cur = nextLeftmost;
        }
    }
}
