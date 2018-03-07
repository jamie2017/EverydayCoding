package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 9/1/16.
 */
public class PathSumII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<>();

        findSum(rst, solution, root, sum);
        return rst;
    }

    private void findSum(List<List<Integer>> result, List<Integer> solution, TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        sum -= root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                solution.add(root.val);
                result.add(new ArrayList<Integer>(solution));
                solution.remove(solution.size() - 1);
            }
            return ;
        }

        solution.add(root.val);
        findSum(result, solution, root.left, sum);
        findSum(result, solution, root.right, sum);
        solution.remove(solution.size() - 1);// !!!
    }
}

