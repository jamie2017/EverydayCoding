package DFS;

import Tree.*;

import java.util.Stack;

/**
 * Created by JMYE on 8/27/16.
 */

// 112. Path Sum
public class HasPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && sum - root.val == 0) return true;
        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
    }

    public boolean hasPathSum_iter(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sums = new Stack<>();

        stack.push(root);
        sums.push(sum);
        while(!stack.isEmpty() && (root != null)) {
            int value = sums.pop();
            TreeNode top = stack.pop();
            if (top.left == null && top.right == null && top.val == value) {
                return true;
            }
            if (top.right != null) {
                stack.push(top.right);
                sums.push(value - top.val);
            }
            if (top.left != null) {
                stack.push(top.left);
                sums.push(value - top.val);
            }
        }
        return false;
    }
}
