package Design;

import java.util.Stack;

/**
 * Created by JMYE on 9/1/16.
 */
public class BSTIterator {

    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            if (cur.left != null) {
                cur = cur.left;
            } else {
                break;
            }
        }

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() { // O(1)
        return !stack.isEmpty();

    }

    /** @return the next smallest number */
    public int next() { // O(1)
        TreeNode node = stack.pop();
        TreeNode cur = node;
        if (cur.right != null) {
            cur = cur.right;
            while (cur != null) {
                stack.push(cur);
                if (cur.left != null) {
                    cur = cur.left;
                }
                else {
                    break;
                }
            }
        }
        return node.val;
    }

    // design 2
    /*
    private Stack<TreeNode> stack = new Stack<>();
    private TreeNode curt;

    // @param root: The root of binary tree.
    public BSTIterator(TreeNode root) {
        curt = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return (curt != null || !stack.isEmpty());
    }

    //@return: return next node
    public int next() {
        while (curt != null) {
            stack.push(curt);
            curt = curt.left;
        }

        curt = stack.pop();
        TreeNode node = curt;
        curt = curt.right;

        return node.val;
    }



    */
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */