package Tree;

/**
 * Created by JMYE on 8/30/16.
 */
public class ConstructBTfromPreInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }


    /*

    // better version
     private int findPosition(int[] arr, int start, int end, int key) {
        int i;
        for (i = start; i <= end; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    private TreeNode myBuildTree(int[] inorder, int instart, int inend,
            int[] preorder, int prestart, int preend) {
        if (instart > inend) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[prestart]);
        int position = findPosition(inorder, instart, inend, preorder[prestart]);

        root.left = myBuildTree(inorder, instart, position - 1,
                preorder, prestart + 1, prestart + position - instart);
        root.right = myBuildTree(inorder, position + 1, inend,
                preorder, position - inend + preend + 1, preend);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length != preorder.length) {
            return null;
        }
        return myBuildTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }
     */
}
