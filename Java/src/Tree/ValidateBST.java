package Tree;

import java.util.Stack;

/**
 * Created by JMYE on 8/29/16.
 */
public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }



    // Iter
    Stack<Integer> stack;
    public boolean isValidBST_iter(TreeNode root) {
        if (root == null) {
            return true;
        }
        stack = new Stack<>();
        inOrder(root);
        int i = stack.pop();
        while (!stack.isEmpty()) {
            int j = stack.pop();
            if (i <= j) {
                return false;
            }
            i = j;
        }
        return true;

    }
    private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            stack.add(root.val);
            inOrder(root.right);
        }
    }
}
