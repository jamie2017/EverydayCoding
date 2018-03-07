package Tree;

/**
 * Created by JMYE on 8/30/16.
 */
public class FlattenBTtoLinkedList {

    // Travser
    private TreeNode lastNode = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }

        lastNode = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }

    // Divide & Conquer
    public void flatten_DC(TreeNode root) {
        flattenHelper(root);
    }

    private TreeNode flattenHelper(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root;
        }

        if (root.left == null) {
            return flattenHelper(root.right);
        }

        if (root.right == null) {
            root.right = root.left;
            root.left = null; // important!
            return flattenHelper(root.right);
        }

        // Divide
        TreeNode leftLastNode = flattenHelper(root.left);
        TreeNode rightLastNode = flattenHelper(root.right);

        // Conquer
        leftLastNode.right = root.right;
        root.right = root.left;
        root.left = null; // important!
        return rightLastNode;
    }
}
