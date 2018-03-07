package ByComs.Google.HandleTrees;

/**
 * Created by JMYE on 7/30/17.
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Definition for a binary tree node.
 */
public class FindDuplicateSubtrees {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        preorder(root, new HashMap<>(), res);
        return res;
    }

    public String preorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
        if (cur == null) return "#";
        String serial = cur.val + "," + preorder(cur.left, map, res) + "," + preorder(cur.right, map, res);
        System.out.println(serial);
        if (map.getOrDefault(serial, 0) <= 1) {
            if (map.getOrDefault(serial, 0) == 1) res.add(cur);
            map.put(serial, map.getOrDefault(serial, 0) + 1);
        }
        return serial;
    }

    public static void main(String[] args) {
        FindDuplicateSubtrees test = new FindDuplicateSubtrees();
        /*

        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
         */

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);
        t1.right.left = new TreeNode(2);
        t1.right.right = new TreeNode(4);
        t1.right.left.left = new TreeNode(4);
        List<TreeNode> t1dupse = test.findDuplicateSubtrees(t1);
        for(TreeNode t: t1dupse) {
            System.out.println("t.val = " + t.val);
        }

    }


}
