package Tree;



import java.util.Stack;

/**
 * Created by JMYE on 9/1/16.
 */
public class VerifyPreorderSequenceinBST {


    /*
      3
     / \
    1   4
   / \
  0   2
  preorder = [3, 1, 0, 2, 4]

  If the tree is BST, then  first it can push all left child into stack
  then each corresponding right child must larger than its left
  elsewise false
     */

    // O(n) stack
    public boolean verifyPreorder_stack(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> path = new Stack();
        for (int p : preorder) {
            if (p < low)
                return false;
            while (!path.empty() && p > path.peek())
                low = path.pop();
            path.push(p);
        }
        return true;
    }
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE, i = -1;
        for (int p : preorder) {
            if (p < low)
                return false;
            while (i >= 0 && p > preorder[i])
                low = preorder[i--];
            preorder[++i] = p;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] preorder = {3,1,0,2,4};
        VerifyPreorderSequenceinBST test = new VerifyPreorderSequenceinBST();
        System.out.println(test.verifyPreorder_stack(preorder));
    }


}
