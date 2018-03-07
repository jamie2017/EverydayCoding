package Tree;

/**
 * Created by JMYE on 8/29/16.
 */
// 108. Convert Sorted Array to Binary Search Tree
public class SortedArraytoBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        // Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
        if (nums.length == 0) {
            return null;
        }
        TreeNode head = helper(nums, 0, nums.length - 1);
        return head;
    }

    public TreeNode helper(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, low, mid - 1);
        node.right = helper(nums, mid + 1, high);
        return node;
    }
}
