package ByComs.SumoLogic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by JMYE on 6/23/17.
 */
public class BinaryTreeOr {
//    public TreeNode doOrBetweenTwoTrees(TreeNode r1, TreeNode r2) {
////        // do or only when both not null
////        if (r1 != null && r2 != null) {
////            TreeNode r3;
////            r3 = new TreeNode(r1.val | r2.val);
////            r3.left = doOrBetweenTwoTrees(r1.left,r2.left);
////            r3.right = doOrBetweenTwoTrees(r1.right,r2.right);
////            return r3;
////        }
////        return null;
//
//        // do or when one of node is not null, return node(1)
////        if (r1 == null && r2 == null) {
////            return null;
////        } else if(r1 == null || r2 == null ) {
////            return new TreeNode(1);
////        } else {
////            TreeNode r3;
////            r3 = new TreeNode(r1.val | r2.val);
////            r3.left = doOrBetweenTwoTrees(r1.left,r2.left);
////            r3.right = doOrBetweenTwoTrees(r1.right,r2.right);
////            return r3;
////        }
//    }


    public TreeNode doOrBetweenTwoTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return null;
        } else if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        } else {
            TreeNode t3 = new TreeNode(t1.val | t2.val);
            t3.left = doOrBetweenTwoTrees(t1.left, t2.left);
            t3.right = doOrBetweenTwoTrees(t1.right, t2.right);
            return t3;
        }
    }

    private void travalTree(TreeNode r) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (r == null) {
            return ;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(r);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> tmpList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode tmpNode = queue.poll();
                tmpList.add(tmpNode.val);
                if (tmpNode.left != null) queue.offer(tmpNode.left);
                if (tmpNode.right != null) queue.offer(tmpNode.right);
            }
            result.add(tmpList);
        }
        System.out.println(result);
    }


    public static void main(String[] args) {
        BinaryTreeOr test = new BinaryTreeOr();
        /*
              0                  1
            /   \              /   \
           1    0             0    1
         */
        TreeNode r1 = new TreeNode(0);
        r1.left = new TreeNode(1);
        r1.right = new TreeNode(0);

        TreeNode r2 = new TreeNode(1);
        r2.left = new TreeNode(0);
        r2.right = new TreeNode(1);

        TreeNode r3 = test.doOrBetweenTwoTrees(r1,r2);
        test.travalTree(r1);
        test.travalTree(r2);
        test.travalTree(r3);
        System.out.println();

        /*
              0                  1
            /   \              /   \
           1    null          0    1
         /  \
      null   1
         */

        r1 = new TreeNode(0);
        r1.left = new TreeNode(1);
        r1.left.right = new TreeNode(1);

        r2 = new TreeNode(1);
        r2.left = new TreeNode(0);
        r2.right = new TreeNode(1);

        r3 = test.doOrBetweenTwoTrees(r1,r2);
        test.travalTree(r1);
        test.travalTree(r2);
        test.travalTree(r3);
        System.out.println(r3.right.val);
    }
}
