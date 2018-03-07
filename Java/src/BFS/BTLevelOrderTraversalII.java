package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by JMYE on 8/25/16.
 */
// 107. Binary Tree Level Order Traversal II
public class BTLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> tmpList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode tmpNode = queue.poll();
                tmpList.add(tmpNode.val);
                if (tmpNode.left != null) queue.offer(tmpNode.left);
                if (tmpNode.right != null) queue.offer(tmpNode.right);
            }
            result.add(0, tmpList); // !!!! nice

        }
        return result;
    }

    public List<List<Integer>> levelOrderBottom_recusive(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }

    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if(root == null) return;
        if(level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        levelMaker(list, root.left, level+1);
        levelMaker(list, root.right, level+1);
        list.get(list.size()-level-1).add(root.val);
    }
}
