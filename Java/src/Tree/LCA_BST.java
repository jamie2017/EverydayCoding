package Tree;

/**
 * Created by JMYE on 8/27/16.
 */

// 235. Lowest Common Ancestor of a Binary Search Tree

public class LCA_BST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0) {
            root = p.val > root.val ? root.right : root.left;
        }
        return root;
    }
    public TreeNode lowestCommonAncestor_recursive(TreeNode root, TreeNode p, TreeNode q) {
//        if(root.val > p.val && root.val > q.val){
//            return lowestCommonAncestor_recursive(root.left, p, q);
//        }else if(root.val < p.val && root.val < q.val){
//            return lowestCommonAncestor_recursive(root.right, p, q);
//        }else{
//            return root;
//        }


        // for case of only two nodes "<="
        return (root.val - p.val) * (root.val - q.val) <= 0 ? root :
                lowestCommonAncestor_recursive(p.val < root.val ? root.left : root.right, p, q);
    }
}
