package Tree;

import java.util.Stack;

/**
 * Created by JMYE on 7/7/17.
 * 530. Minimum Absolute Difference in BST
 */
public class MinimumAbsoluteDifferenceinBST {
    public int getMinimumDifference(TreeNode root) {
        int minDif = Integer.MAX_VALUE;
        TreeNode prev = null;
        Stack<TreeNode> stk = new Stack<>();
        while(!stk.isEmpty() || root != null) {
            if (root != null) {
                stk.add(root);
                root = root.left;
            } else {
                TreeNode node = stk.pop();
                if (prev != null) {
                    minDif = Math.min(minDif, Math.abs(node.val - prev.val));
                }
                prev = node;
                root = node.right;
            }
        }
        return minDif;
    }
}
