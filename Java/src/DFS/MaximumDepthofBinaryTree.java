package DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by JMYE on 8/24/16.
 */
public class MaximumDepthofBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
    public int maxDepth_BFS(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<TreeNode> queue =  new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            depth++;
            for (int i = 0; i < levelSize; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
        }
        return depth;
    }

    public int maxDepth_DFS(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Stack<TreeNode> path = new Stack<>();
        Stack<Integer> depthList = new Stack<>();
        path.push(root);
        depthList.push(1);
        while (!path.isEmpty()) {
            TreeNode tmpNode = path.pop();
            int tmpVal = depthList.pop();
            if (tmpNode.left == null && tmpNode.right == null) {
                depth = Math.max(depth,tmpVal);
            }
            if (tmpNode.left != null) {
                path.push(tmpNode.left);
                depthList.push(tmpVal + 1);
            }
            if (tmpNode.right != null) {
                path.push(tmpNode.right);
                depthList.push(tmpVal + 1);
            }
        }
        return depth;
    }
}
