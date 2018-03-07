package DFS;

/**
 * Created by JMYE on 8/28/16.
 */
// 110. Balanced Binary Tree
public class BalancedBT {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(getH(root.left) - getH(root.right)) > 1) return false;
        else return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getH(TreeNode root) {
        if (root == null) return 0;
        int leftH = getH(root.left);
        int rightH = getH(root.right);
        return Math.max(leftH, rightH) + 1;
    }

    // Version 2

    public boolean isBalanced2(TreeNode root) {
        return maxDepth(root) != -1;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left == -1 || right == -1 || Math.abs(left-right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}

