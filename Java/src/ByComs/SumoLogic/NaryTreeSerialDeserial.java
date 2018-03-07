package ByComs.SumoLogic;

import java.util.Stack;

/**
 * Created by JMYE on 6/22/17.
 * 任意叉树的序列化和逆序列化。
 */
public class NaryTreeSerialDeserial {
    public NaryTreeNode deserialize(StringBuilder treeSerial) {
        NaryTreeNode root = null;
        NaryTreeNode parent = null;
        Stack<NaryTreeNode> stk = new Stack<>();
        int pos = 0;
        while (pos < treeSerial.length()) {
            if(treeSerial.charAt(pos) == '(') {
                pos ++;
                NaryTreeNode node = new NaryTreeNode(treeSerial.charAt(pos) - '0');
                if (parent == null) {
                    root = node;
                } else {
                    parent.getChildren().add(node);
                }
                stk.push(node);
                parent = node;
            } else if (treeSerial.charAt(pos) == ')') {
                stk.pop();
                if (!stk.isEmpty()) {
                    parent = stk.peek();
                }
            }
            pos ++;
        }
        return root;
    }

    public void serialize(NaryTreeNode root, StringBuilder treeSerial) {
        if (root != null) {
            treeSerial.append('(');
            treeSerial.append(root.getValue());
            for (Object child: root.getChildren()) {
                serialize((NaryTreeNode) child,treeSerial);
            }
            treeSerial.append(')');
        }
    }

    public static void main(String[] args) {
        NaryTreeSerialDeserial test = new NaryTreeSerialDeserial();
        StringBuilder inS = new StringBuilder("(1(2)(3(5)(6))(4(7)))");
        StringBuilder outS = new StringBuilder();
        test.serialize(test.deserialize(inS),outS);
        System.out.println(outS.toString());
    }
}
