package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by JMYE on 7/9/17.
 */
public class AvgLevelBT {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avgPerLevel = new ArrayList<>();
        if (root == null) {
            return avgPerLevel;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            double vals = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                vals += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            avgPerLevel.add(vals/levelSize);
        }
        return avgPerLevel;
    }
}
