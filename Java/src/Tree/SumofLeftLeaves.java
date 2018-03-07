package Tree;

import java.util.Stack;

/**
 * Created by JMYE on 10/5/16.
 */
public class SumofLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int leavesSum = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                leavesSum += root.left.val;
            } else {
                leavesSum += sumOfLeftLeaves(root.left);
            }
        }
        if (root.right != null) {
            leavesSum += sumOfLeftLeaves(root.right);
        }
        return leavesSum;
    }

    public int sumOfLeftLeaves_iter(TreeNode root) {
        if(root == null) return 0;
        int leavesSum = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.empty()) {
            TreeNode node = stack.pop();
            if(node.left != null) {
                if (node.left.left == null && node.left.right == null)
                    leavesSum += node.left.val;
                else
                    stack.push(node.left);
            }
            if(node.right != null) {
                if (node.right.left != null || node.right.right != null)
                    stack.push(node.right);
            }
        }
        return leavesSum;
    }
}
