package Tree;

/**
 * Created by JMYE on 5/16/17.
 */
public class InsertNodeInBST {
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        TreeNode cur = root;
        if (root == null) {
            return node;
        }
        while(cur != null) {
            if (node.val > cur.val) {
                if (cur.right == null) {
                    cur.right = node;
                    break;
                }
                else {
                    cur = cur.right;
                }
            } else if (node.val < cur.val) {
                if (cur.left != null) {
                    cur.left = node;
                    break;
                } else {
                    cur = cur.left;
                }
            } else {
                break;
            }
        }
        return root;
    }
}
