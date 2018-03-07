package DFS;

/**
 * Created by JMYE on 9/1/16.
 */
public class SumRoottoLeafNumbers {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root,0);
    }
    private int sumNumbers(TreeNode root, int prev) {
        if (root == null) {
            return 0;
        }
        int cur = prev * 10 + root.val;
        if (root.left == null && root.right == null) {
            return cur;
        }
        return sumNumbers(root.left, cur) + sumNumbers(root.right,cur);
    }
}
