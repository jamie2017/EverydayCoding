package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by JMYE on 9/2/16.
 */
public class ClosestBinarySearchTreeValueII { // !!!MARK
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // Eg. target = 11.2, k = 4
        List<Integer> res = new ArrayList<>();

        Stack<Integer> s1 = new Stack<>(); // predecessors
        Stack<Integer> s2 = new Stack<>();  // successors

        inorder(root, target, true, s1); // s1 = [7,9,10,11] store value <= target in s1
        inorder(root, target, false, s2);  // s2 = [15,13,12]  store value > target in s2
        while (k-- > 0) {
            if (s1.isEmpty()) {
                res.add(s2.pop());
            } else if (s2.isEmpty()) {
                res.add(s1.pop());
            } else if (Math.abs(s1.peek() - target) < Math.abs(s2.peek() - target)) { // compare (11 - target) vs (12 - target)
        res.add(s1.pop());
    } else {
        res.add(s2.pop());
    }
}
        return res;
                }
private void inorder(TreeNode root, double target, boolean leftToRight, Stack<Integer> stack) {
        if (root == null) return ;

        inorder(leftToRight? root.left:root.right, target, leftToRight, stack);
        // early terminate, no need to traverse the whole tree
        if((leftToRight && root.val > target) || (!leftToRight && root.val <= target)) return;
        // track the value of current node
        stack.push(root.val);
        inorder(leftToRight ? root.right : root.left, target, leftToRight, stack);
        }

public static void main (String[] args) {
        TreeNode root = new TreeNode(11);
        root.left = new TreeNode(9);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(10);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(15);

        double target = 13.2;
        int k = 4;
        ClosestBinarySearchTreeValueII test = new ClosestBinarySearchTreeValueII();
        System.out.println(test.closestKValues(root,target,k));
    }
}
