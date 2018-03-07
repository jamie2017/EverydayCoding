package ByComs.Amazon.OA2;

/**
 * Created by JMYE on 10/9/16.
 */
public class OverlapRectangle {
    // rectangle A, B
    // time O(1), space O(1)
    // if overlap return true, else return false
    public static boolean check(Node topLeftA, Node topLeftB, Node bottomRightA, Node bottomRightB) {
        // 回
        if ((bottomRightA.x < bottomRightB.x
                && bottomRightA.y > bottomRightB.y
                && topLeftA.x > topLeftB.x
                && topLeftA.y < topLeftB.y)
            || (bottomRightB.x < bottomRightA.x
                && bottomRightB.y > bottomRightA.y
                && topLeftB.x > topLeftA.x
                && topLeftB.y < topLeftA.y)) {
            return true;
        }


        if (topLeftA.y <= bottomRightB.y || topLeftB.y <= bottomRightA.y) {
            return false;
        }

        if (topLeftA.x >= bottomRightB.x || topLeftB.x >= bottomRightA.x) {
            return false;
        }
        return true;
    }
    public static class Node {
        double x;
        double y;
        public Node(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}

//更简单的，一行解决
// return !(bottomRightA.y <= topLeftB.y || bottomRightB.y <= topLeftA.y || topLeftA.x >= bottomRightB.x || topLeftB.x >= bottomRightA.x);
