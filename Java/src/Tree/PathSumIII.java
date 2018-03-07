package Tree;
import java.util.*;
import java.util.HashMap;

/**
 * Created by JMYE on 10/29/16.
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) { // O(NlogN) ~ O(N^2）
        if (root == null) return 0;

        int pathFromRoot = countPathsWithSumFromNode(root, sum, 0);
        int pathOnLeft = pathSum(root.left, sum);
        int pathOnRight = pathSum(root.right,sum);
        return pathFromRoot + pathOnLeft + pathOnRight;
    }

    private int countPathsWithSumFromNode(TreeNode node, int sum, int currentSum) {
        if (node == null) return 0;
        currentSum += node.val;
        int totalPaths = 0;
        if (currentSum == sum) {
            totalPaths++;
        }

        totalPaths += countPathsWithSumFromNode(node.left,  sum, currentSum);
        totalPaths += countPathsWithSumFromNode(node.right,  sum, currentSum);
        return totalPaths;
    }

    public int pathSum_opt(TreeNode root, int sum) {
        return countPathsWithSum(root, sum, 0, new HashMap<Integer, Integer>());
    }


    private int countPathsWithSum(TreeNode node, int targetSum, int runningSum,
                                  HashMap<Integer, Integer> pathCount) {
        if (node == null) return 0;

        runningSum += node.val;
        int sum = runningSum - targetSum;
        int totalPaths = pathCount.getOrDefault(sum, 0);

        if (runningSum == targetSum) {
            totalPaths++;
        }
        incrementHashtable(pathCount, runningSum,1);
        totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
        totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
        incrementHashtable(pathCount, runningSum, -1);
        return totalPaths;
    }

    private void incrementHashtable(HashMap<Integer, Integer> hashTable, int key, int delta) {
        int newCount = hashTable.getOrDefault(key, 0) + delta;
        if (newCount == 0) {
            hashTable.remove(key);
        } else {
            hashTable.put(key, newCount);
        }
    }
}
