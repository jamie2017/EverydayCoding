package ByComs.Amazon.OnlineAssessment;

/**
 * Created by JMYE on 10/10/16.
 */
public class BSTMinimumPathSum {
    public int minPathSum(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right != null) return root.val + minPathSum(root.right);
        if (root.right == null && root.left != null) return root.val + minPathSum(root.left);
        return Math.min(minPathSum(root.left), minPathSum(root.right)) + root.val;
    }
}
