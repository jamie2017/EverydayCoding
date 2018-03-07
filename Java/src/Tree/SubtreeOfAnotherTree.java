package Tree;

import java.util.Stack;

/**
 * Created by JMYE on 5/9/17.
 * 572. Subtree of Another Tree
 */

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String sInorder = generateInorderString(s);
        String tInorder = generateInorderString(t);
        return sInorder.contains(tInorder);
    }

    private String generateInorderString(TreeNode s) {
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stackTree = new Stack<>();
        stackTree.push(s);
        while(!stackTree.isEmpty()) {
            TreeNode node = stackTree.pop();
            if (node == null) {
                sb.append(",#");
            } else {
                sb.append("," + node.val);
                stackTree.push(node.right);
                stackTree.push(node.left);
            }
        }
        return sb.toString();
    }

    public boolean isSubtree2(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s,t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
