package DFS;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by JMYE on 8/29/16.
 */
// 144. Binary Tree Preorder Traversal

public class BTPreorderTraversal {


    // Non-recursion
    public List<Integer> preorderTraversal_iter(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> preorder = new ArrayList<Integer>();

        if (root == null) {
            return preorder;
        }

        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            preorder.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return preorder;
    }



    // Traversal
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        traverse(root,res);
        return res;
    }

    public void traverse(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }

    // Divide & Conquer
    public List<Integer> preorderDivideConquer(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        // null or leaf
        if (root == null) {
            return result;
        }

        // Divide
        ArrayList<Integer> left = (ArrayList<Integer>) preorderDivideConquer(root.left);
        ArrayList<Integer> right = (ArrayList<Integer>) preorderDivideConquer(root.right);

        // Conquer
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }


    public static void main(String[] argus) {

        /*
              3
             / \
            1   4
           / \
          0   2
      preorder = [3, 1, 0, 2, 4]
    */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);

        BTPreorderTraversal test = new BTPreorderTraversal();
        List<Integer> testres = test.preorderTraversal_iter(root);
        for (Integer i: testres) {
            System.out.println(i);
        }
    }
}
