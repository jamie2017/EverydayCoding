package BinarySearch;

/**
 * Created by JMYE on 8/25/16.
 */
// 270. Closest Binary Search Tree Value
public class ClosestBSTValue { // MARK
    public int closestValue(TreeNode root, double target) {
        int a = root.val;
        TreeNode kid = a < target? root.right:root.left;
        if(kid == null) return a;
        int b = closestValue(kid,target);
        return Math.abs(a - target) < Math.abs(b - target)? a:b;
    }
}
