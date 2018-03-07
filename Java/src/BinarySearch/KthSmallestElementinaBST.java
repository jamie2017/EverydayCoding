package BinarySearch;


import java.util.Stack;

/**
 * Created by JMYE on 9/1/16.
 */
public class KthSmallestElementinaBST {

    //Binary Search
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left,k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k - 1 - count);
        }
        return root.val;
    }

    private int countNodes(TreeNode n) {
        if (n == null) return 0;
        return 1 + countNodes(n.left) + countNodes(n.right);
    }

}

    /*
    // design
    private Stack<TreeNode> stack = new Stack<>();
    private TreeNode curt;
    public boolean hasNext() {
        return (curt != null || !stack.isEmpty());
    }

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


    public int kthSmallest(TreeNode root, int k) {
        curt = root;
        int result = 0;
        while (k > 0) {
            if (hasNext()){
                result = next();
                k--;
            }
        }
        return result;

    }


*/
/*
// recursive

int count = 0;
int result = Integer.MIN_VALUE;

public int kthSmallest(TreeNode root, int k) {
    traverse(root, k);
    return result;
}

public void traverse(TreeNode root, int k) {
    if(root == null) return;
    traverse(root.left, k);
    count ++;
    if(count == k) result = root.val;
    traverse(root.right, k);
}

//Iterative

 public int kthSmallest(TreeNode root, int k) {
     Stack<TreeNode> stack = new Stack<TreeNode>();
     TreeNode p = root;
     int count = 0;

     while(!stack.isEmpty() || p != null) {
         if(p != null) {
             stack.push(p);  // Just like recursion
             p = p.left;

         } else {
            TreeNode node = stack.pop();
            if(++count == k) return node.val;
            p = node.right;
         }
     }

     return Integer.MIN_VALUE;
 }



 */
