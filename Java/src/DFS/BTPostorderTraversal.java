package DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by JMYE on 8/29/16.
 */
public class BTPostorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // Non-recursivie  MARK

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        TreeNode current = root;
        TreeNode parent = null,lastTraversed = null;
        while (!stk.isEmpty() || current != null) {
            if (current != null) {
                stk.add(current);
                current = current.left;
            } else {
                parent = stk.peek();
                if (parent.right == null || parent.right == lastTraversed) {
                    result.add(parent.val);
                    lastTraversed = stk.pop();
                } else {
                    current = parent.right;
                }
            }
        }
        return result;
    }

    /*
             5
           /   \
          3    4
         / \  / \
        1  2  #  6

    >> 123 6 4 5
     */


    // Traversal
    public List<Integer> postorderTraversalRec(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root,result);
        return result;
    }
    public void traversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        traversal(root.left, result);
        traversal(root.right, result);
        result.add(root.val);
    }




    // Divide Conquer
    public List<Integer> postorderTraversal_Divide_conquer(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // Divide
        List<Integer> left = postorderTraversal_Divide_conquer(root.left);
        result.addAll(left);
        List<Integer> right = postorderTraversal_Divide_conquer(root.right);
        result.addAll(right);
        result.add(root.val);
        return result;
    }

    public static void main(String[] args) {
        BTPostorderTraversal test = new BTPostorderTraversal();
        TreeNode r = new TreeNode(5);
        r.left = new TreeNode(3);
        r.right = new TreeNode(4);
        r.left.left = new TreeNode(1);
        r.left.right = new TreeNode(2);
        r.right.right = new TreeNode(6);
        System.out.println(test.postorderTraversal(r));
        System.out.println(test.postorderTraversalRec(r));
    }



}
