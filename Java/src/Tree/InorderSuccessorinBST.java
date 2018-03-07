package Tree;

/**
 * Created by JMYE on 9/1/16.
 */
public class InorderSuccessorinBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null) {
            if (root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return successor;
    }


    // recursive
    public TreeNode inorderSuccessor_rec(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val <= p.val) {
            return inorderSuccessor_rec(root.right, p);
        } else {
            TreeNode left = inorderSuccessor_rec(root.left, p);
            return (left != null) ? left : root;
        }
    }
}
