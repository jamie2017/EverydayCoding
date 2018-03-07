package HashTable;


import java.util.*;

/**
 * Created by JMYE on 9/13/16.
 */
public class BTVerticalOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (root == null) {
            return rst;
        }
        HashMap<Integer, List<Integer>> colBucket = new HashMap<>();

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();
        nodeQueue.add(root);
        colQueue.add(0);
        int min = 0,max = 0;
        while(!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            int col = colQueue.poll();
            if(!colBucket.containsKey(col)) colBucket.put(col, new ArrayList<Integer>());
            colBucket.get(col).add(node.val);

            if (node.left != null) {
                nodeQueue.add(node.left);
                colQueue.add(col - 1);
                if(col <= min) min = col - 1;
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
                colQueue.add(col + 1);
                if(col >= max) max = col + 1;
            }
        }

        for (int i = min; i <= max; i++) {
            rst.add(colBucket.get(i));
        }
        return rst;
    }
    /* // USE TreeMap
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (root == null) {
            return rst;
        }
        HashMap<Integer, List<Integer>> colBucket = new HashMap<>();

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();
        nodeQueue.add(root);
        colQueue.add(0);
        int min = 0,max = 0;
        while(!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            int col = colQueue.poll();
            if(!colBucket.containsKey(col)) colBucket.put(col, new ArrayList<Integer>());
		    colBucket.get(col).add(node.val);

            if (node.left != null) {
                nodeQueue.add(node.left);
                colQueue.add(col - 1);
                if(col <= min) min = col - 1;
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
                colQueue.add(col + 1);
                if(col >= max) max = col + 1;
            }
        }

        for (int i = min; i <= max; i++) {
            rst.add(colBucket.get(i));
        }
        return rst;
    }



     */
}
