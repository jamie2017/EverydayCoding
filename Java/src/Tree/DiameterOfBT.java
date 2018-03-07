package Tree;

/**
 * Created by JMYE on 3/16/17.
 */
public class DiameterOfBT {
    public int MaxDiameter(TreeNode root) {// O(n^2)
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int leftDia = MaxDiameter(root.left);
        int rightDia = MaxDiameter(root.right);
        int maxSubDia = Math.max(leftDia, rightDia);
        return Math.max(maxSubDia, leftHeight + rightHeight + 1);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left),getHeight(root.right)) + 1;
    }

    static class NodePair{
        int height ;
        int diameter ;
    }
    //Note: The length of path between two nodes is represented by the number of edges between them.
    public int MaxDiameterOpt(TreeNode root) { // O(n)
        return root == null ? 0: getDiameter(root).diameter - 1;

    }

    private NodePair getDiameter(TreeNode root) {
        NodePair pair = new NodePair();
        if (root == null) {
            pair.height = 0;
            pair.diameter = 0;
            return pair;
        }
        NodePair left = getDiameter(root.left);
        NodePair right = getDiameter(root.right);
        pair.diameter = Math.max(left.height + right.height + 1, Math.max(left.diameter, right.diameter));
        pair.height = Math.max(left.height, right.height) + 1;
        return pair;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);
        TreeNode n12 = new TreeNode(12);
        TreeNode n13 = new TreeNode(13);
        TreeNode n14 = new TreeNode(14);
        TreeNode n15 = new TreeNode(15);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n6;
        n6.left = n7;
        n5.left = n9;
        n5.right = n8;
        n8.right = n10;
        n3.right = n11;
        n11.left = n12;
        n12.right = n13;
        n13.left = n14;
        n14.right = n15;
        DiameterOfBT test = new DiameterOfBT();
        System.out.println(test.MaxDiameter(n1));
        System.out.println(test.MaxDiameterOpt(n1));
    }
}
