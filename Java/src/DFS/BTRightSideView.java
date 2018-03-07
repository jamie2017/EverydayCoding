package DFS;

import java.util.*;

/**
 * Created by JMYE on 9/1/16.
 */
public class BTRightSideView {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // bfs
    public List<Integer> rightSideView_bfs(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        if (root == null) {
            return rst;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize;
        TreeNode tmpNode = new TreeNode(0);
        while (!queue.isEmpty()) {
            levelSize = queue.size();
            while(levelSize > 0) {
                tmpNode = queue.poll();
                if (tmpNode.left != null) {
                    queue.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    queue.offer(tmpNode.right);
                }
                levelSize --;
            }
            rst.add(tmpNode.val);
        }
        return rst;
    }

    // dfs
    public List<Integer> rightSideView(TreeNode root) {
        HashMap<Integer, Integer> depthToValue = new HashMap<Integer, Integer>();
        viwe_dfs(depthToValue, root, 1);

        int depth = 1;
        List<Integer> result = new ArrayList<Integer>();
        while (depthToValue.containsKey(depth)) {
            result.add(depthToValue.get(depth));
            depth++;
        }
        return result;
    }

    private void viwe_dfs(HashMap<Integer, Integer> depthToValue, TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        depthToValue.put(depth, node.val);
        viwe_dfs(depthToValue, node.left, depth + 1);
        viwe_dfs(depthToValue, node.right, depth + 1);
    }
}
