package Tree;
public class ConvertBTtoDLL {
    public TreeNode convertBTtoCircularDLL(TreeNode root) {
        if (root == null)
            return null;
        TreeNode[] rst =  dfs(root); // this step only convert as DLL
        TreeNode head = rst[0];
        TreeNode tail = rst[rst.length - 1];
        head.left = tail;
        tail.right = head;
        return head; // now it's circular
    }

    private TreeNode[] dfs(TreeNode root) {
        if (root == null)
            return null;
        TreeNode[] left = dfs(root.left);
        TreeNode head = null;
        TreeNode tail = null;
        if (left != null) {
            head = left[0];
            left[1].right = root;
            root.left = left[1];
        }
        TreeNode[] right = dfs(root.right);
        if (right != null) {
            root.right = right[0];
            right[0].left = root;
            tail = right[1];
        }
        TreeNode[] ret = new TreeNode[2];
        ret[0] = (head == null ? root : head);
        ret[1] = (tail == null ? root : tail);
        return ret;
    }

    public void display(TreeNode head)
    {
        System.out.println("Circular Linked List is :");
        System.out.println("Head val :" + head.val);
        TreeNode itr = head;
        do {
            System.out.print(itr.val+ " " );
            itr = itr.right;
        }
        while (itr != head);
        System.out.println();
        System.out.println("**************");
        do {
            System.out.print(itr.val+ " " );
            itr = itr.left;
        }
        while (itr != head);
    }


    public static void main(String[] args) {
        ConvertBTtoDLL test = new ConvertBTtoDLL();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);
        TreeNode head = test.convertBTtoCircularDLL(root);
        test.display(head);
    }

}
