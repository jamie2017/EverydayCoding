package DFS;

/**
 * Created by JMYE on 9/1/16.
 */
public class PopulatingNextRightPointersinEachNodeII {
    public void connectII(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode cur = root;
        TreeLinkNode pre;
        TreeLinkNode nextLeftmost;
        while (cur != null) {
            pre = null;
            nextLeftmost = null;
            while (cur != null) {
                if (nextLeftmost == null) {
                    nextLeftmost = (cur.left != null) ? cur.left: cur.right;
                }

                if (cur.left != null) {
                    if (pre != null) {
                        pre.next = cur.left;
                        pre = pre.next;
                    } else {
                        pre = cur.left;
                    }
                }

                if (cur.right != null) {
                    if (pre != null) {
                        pre.next = cur.right;
                        pre = pre.next;
                    } else {
                        pre = cur.right;
                    }
                }
                cur = cur.next;
            }
            cur = nextLeftmost;
        }
    }
}
