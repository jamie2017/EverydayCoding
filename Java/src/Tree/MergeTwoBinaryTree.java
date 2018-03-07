package Tree;

/**
 * Created by JMYE on 6/29/17.
 * 617. Merge Two Binary Trees
 */
public class MergeTwoBinaryTree {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return null;
        } else if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        } else {
            TreeNode t3;
            t3 = new TreeNode(t1.val + t2.val);
            t3.left = mergeTrees(t1.left, t2.left);
            t3.right = mergeTrees(t1.right, t2.right);
            return t3;
        }
    }
}
