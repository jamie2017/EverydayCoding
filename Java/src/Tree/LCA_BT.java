package Tree;

import java.util.*;

/**
 * Created by JMYE on 8/29/16.
 */
public class LCA_BT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) { // lca is p or q
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) { // here use two "！= null" is because it return value meaning
            //we can find p or q in left or right separately, thus the LCA is root
            return root;
        }

        return left != null ? left : right;
    }

    public TreeNode lcaIterative(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stk = new Stack<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        stk.add(root);
        while(!stk.isEmpty()) {
            TreeNode node = stk.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stk.add(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stk.add(node.right);
            }
        }
        Set<TreeNode> ancestor = new HashSet<>();
        while (p != null) {
            ancestor.add(p);
            p = parent.get(p);
        }
        while (!ancestor.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }
}
