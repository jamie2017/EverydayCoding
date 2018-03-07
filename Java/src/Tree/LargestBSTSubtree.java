package Tree;

/**
 * Created by JMYE on 8/30/16.
 */
public class LargestBSTSubtree { // O(N)
    class SuperNode {  // (size, rangeLower, rangeUpper) -- size of current tree, range of current tree [rangeLower, rangeUpper]
        int size;
        int lower;
        int upper;

        SuperNode(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }

    int maxSize = 0;

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) { return 0; }
        traverse(root);
        return maxSize;
    }

    private SuperNode traverse(TreeNode root) {
        if (root == null) { return new SuperNode(0, Integer.MAX_VALUE, Integer.MIN_VALUE); }
        SuperNode left = traverse(root.left);
        SuperNode right = traverse(root.right);
        if (left.size == -1 || right.size == -1 || root.val <= left.upper || root.val >= right.lower) {
            return new SuperNode(-1, 0, 0);
        }
        int size = left.size + 1 + right.size;
        maxSize = Math.max(size, maxSize);
        return new SuperNode(size, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
    }
}
