package DFS;

/**
 * Created by JMYE on 8/27/16.
 */
// 111. Minimum Depth of Binary Tree
public class MinDepthBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return  (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
    }
}
