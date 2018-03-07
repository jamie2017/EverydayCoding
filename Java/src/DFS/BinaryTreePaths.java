package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 8/27/16.
 */
public class BinaryTreePaths {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<String> binaryTreePaths(TreeNode root){
        List<String> answer = new ArrayList<>();
        if (root != null) searchBT(root, "", answer);
        return answer;
    }

    private void searchBT(TreeNode root, String path, List<String> rst) {
        if (root.left == null && root.right == null) rst.add(path + root.val);
        if (root.left != null) searchBT(root.left,path + root.val + "->", rst);
        if(root.right != null) searchBT(root.right, path + root.val + "->", rst);
    }

    public List<String> binaryTreePaths_nohelper(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;
        if (root.left == null && root.right == null) {
            paths.add(root.val + "");
            return paths;
        }
        for (String path: binaryTreePaths_nohelper(root.left)) {
            paths.add(root.val + "->" + path);
        }
        for (String path: binaryTreePaths_nohelper(root.right)) {
            paths.add(root.val + "->" + path);
        }
        return paths;
    }
}
