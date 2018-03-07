package Stack;

import java.util.Stack;

/**
 * Created by JMYE on 11/28/16.
 */
public class VerifyPreorderSerializationOfaBinaryTree {
    /*
    In a binary tree, if we consider null as leaves, then

all non-null node provides 2 outdegree and 1 indegree (2 children and 1 parent), except root
all null node provides 0 outdegree and 1 indegree (0 child and 1 parent).
Suppose we try to build this tree. During building, we record the difference between out degree and in degree diff = outdegree - indegree.
When the next node comes, we then decrease diff by 1,
because the node provides an in degree. If the node is not null, we increase diff by 2,
because it provides two out degrees.
If a serialization is correct, diff should never be negative and diff will be zero when finished.
     */
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node : nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }
    public boolean isValidSerialization_postOrder(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (int i = nodes.length; i >=0; i--) {
            if (--diff < 0) return false;
            if (!nodes[i].equals("#")) diff += 2;
        }
        return diff == 0;
    }

    // using stack
    /*
     // using a stack, scan left to right
        // case 1: we see a number, just push it to the stack
        // case 2: we see #, check if the top of stack is also #
        // if so, pop #, pop the number in a while loop, until top of stack is not #
        // if not, push it to stack
        // in the end, check if stack size is 1, and stack top is #
     */
    public boolean isValidSerialization_stack(String preorder) {
        if (preorder == null) return false;
        Stack<String> stack = new Stack<>();
        String[] strs = preorder.split(",");
        for (int i = 0; i < strs.length; i++) {
            String cur = strs[i];
            while (cur.equals("#") && !stack.isEmpty() && stack.peek().equals(cur)) {
                stack.pop();
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
            stack.push(cur);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
}
