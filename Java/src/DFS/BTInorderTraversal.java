package DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by JMYE on 8/29/16.
 */
public class BTInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // Non-recursive
    public List<Integer> inorderTraversal_iter(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        TreeNode curt = root;
        while (curt != null || !stack.empty()) {
            while (curt != null) {
                stack.add(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            result.add(curt.val);
            curt = curt.right;
        }
        return result;
    }

    // Traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }
    public void traversal(TreeNode root, List<Integer> result) {
        if (root == null) return;
        traversal(root.left, result);
        result.add(root.val);
        traversal(root.right, result);
    }


    // Divide & Conquer

    public List<Integer> inorderTraversal_Divide_Conquer(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // Divide
        List<Integer> left = inorderTraversal_Divide_Conquer(root.left);
        result.addAll(left);
        result.add(root.val);
        List<Integer> right = inorderTraversal_Divide_Conquer(root.right);
        result.addAll(right);
        return result;

    }
}
