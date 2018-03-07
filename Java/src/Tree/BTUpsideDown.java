package Tree;

/**
 * Created by JMYE on 8/29/16.
 */
// 156. Binary Tree Upside Down
public class BTUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode curr = root;
        TreeNode prev = null;
        TreeNode next = null;
        TreeNode temp = null;

        while (curr != null) { // like swap two elements, need 1 tmp
                               // now swap three elements, need two tmps

            /*
                1
               / \
              2   3


            */
            // first loop curr = 2, tmp = 3, prev = 1
            // second loop  next = null, curr.left = 3, curr.right = 1, prev= curr, curr = next = null
            next = curr.left;
            curr.left = temp;
            temp = curr.right;
            curr.right = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main (String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        BTUpsideDown test = new BTUpsideDown();
        TreeNode newRoot = test.upsideDownBinaryTree(root);

    }

}
