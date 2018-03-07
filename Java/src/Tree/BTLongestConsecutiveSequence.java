package Tree;

/**
 * Created by JMYE on 7/31/17.
 */
public class BTLongestConsecutiveSequence {
    int longestPathSize = 0;
    public int longestConsecutive(TreeNode root) {
        longestConsecutiveHelper(root);
        return longestPathSize;
    }

    private int longestConsecutiveHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftPathSize = longestConsecutiveHelper(root.left);
        int rightPathSize = longestConsecutiveHelper(root.right);
        int cutSize =  1;
        if (root.left != null && root.left.val == root.val + 1) {
            cutSize = Math.max(cutSize, leftPathSize + 1);
        }
        if (root.right != null && root.right.val == root.val + 1) {
            cutSize = Math.max(cutSize, rightPathSize + 1);
        }
        longestPathSize = Math.max(longestPathSize,Math.max(cutSize,Math.max(leftPathSize,rightPathSize)));
        return cutSize;
    }
}
