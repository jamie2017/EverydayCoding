package DFS;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JMYE on 9/2/16.
 */
public class HouseRobberIII { // dfs + memo
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int rob_dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int val = 0;

        if (root.left != null) {
            val += rob_dfs(root.left.left) + rob_dfs(root.left.right);
        }

        if (root.right != null) {
            val += rob_dfs(root.right.left) + rob_dfs(root.right.right);
        }

        return Math.max(val + root.val, rob_dfs(root.left) + rob_dfs(root.right));
    }

    public int rob_dp1(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        return robSub(root, map);
    }

    private int robSub(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);

        int val = 0;

        if (root.left != null) {
            val += robSub(root.left.left, map) + robSub(root.left.right, map);
        }

        if (root.right != null) {
            val += robSub(root.right.left, map) + robSub(root.right.right, map);
        }

        val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
        map.put(root, val);

        return val;
    }

    public int rob_dp2(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(TreeNode root) {
        if (root == null) {
            return new int[2];
        }

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);

        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }
}
