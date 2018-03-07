package ByComs.Amazon.OnlineAssessment;

/**
 * Created by JMYE on 10/10/16.
 */
import java.util.*;

class Node {
    int val;
    ArrayList<Node> children;
    public Node (int val) {
        this.val = val;
        children = new ArrayList<Node>();
    }
}

class SumCount {
    int sum;
    int count;
    public SumCount(int sum, int count) {
        this.sum = sum;
        this.count = count;
    }
}
public class MaximumSubtreeOfAverage { // LC 333

    private static double resAve = Double.MIN_VALUE;
    private static Node rst;

    public static Node getHighAve(Node root) {
        if (root == null) return null;
        dfs(root);
        return rst;
    }

    private static SumCount dfs(Node root) {
        if (root.children == null || root.children.size() == 0) {
            return new SumCount(root.val, 1);
        }
        int curSum = root.val;
        int curCnt = 1;
        for (Node child : root.children) {
            SumCount childSC = dfs(child);
            curSum += childSC.sum;
            curCnt += childSC.count;
        }
        double curAve = (double) curSum / curCnt;
        if (resAve < curAve) {
            resAve = curAve;
            rst = root;
        }
        return new SumCount(curSum, curCnt);
    }



    public static void main(String[] args) {
        Node root = new Node(1);
        Node l21 = new Node(2);
        Node l22 = new Node(3);
        Node l23 = new Node(4);
        Node l31 = new Node(5);
        Node l32 = new Node(5);
        Node l33 = new Node(5);
        Node l34 = new Node(5);
        Node l35 = new Node(5);
        Node l36 = new Node(5);

        l21.children.add(l31);
        l21.children.add(l32);

        l22.children.add(l33);
        l22.children.add(l34);

        l23.children.add(l35);
        l23.children.add(l36);

        root.children.add(l21);
        root.children.add(l22);
        root.children.add(l23);

        Node res = getHighAve(root);
        System.out.println(res.val + " " + resAve);
    }

}
