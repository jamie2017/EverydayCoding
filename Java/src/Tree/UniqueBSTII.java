package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 8/29/16.
 */
public class UniqueBSTII {
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> treeList = new ArrayList<>();
        if (start > end) {
            treeList.add(null);
        }
        for (int i = start; i <= end; i++) {
            for (TreeNode left: generateTrees(start, i - 1)) {
                for (TreeNode right: generateTrees(i + 1, end)) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = left;
                    cur.right = right;
                    treeList.add(cur);
                }
            }
        }
        return treeList;
    }
}
