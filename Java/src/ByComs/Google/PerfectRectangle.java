package ByComs.Google;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by JMYE on 11/17/16.
 */
public class PerfectRectangle {
    public static boolean isRectangleCover(int[][] rectangles) {

        if (rectangles.length == 0 || rectangles[0].length == 0) return false;
        int rectangleArea = 0;
        Set<String> set = new HashSet<>();
        int leftMostX = Integer.MAX_VALUE, leftMostY = Integer.MAX_VALUE;
        int rightMostX = Integer.MIN_VALUE, rightMostY = Integer.MIN_VALUE;
        for (int[] rec : rectangles) {
            leftMostX = Math.min(leftMostX, rec[0]);
            leftMostY = Math.min(leftMostY, rec[1]);
            rightMostX = Math.max(rightMostX, rec[2]);
            rightMostY = Math.max(rightMostY, rec[3]);
            // (1) check if the sum of area equals to the target area
            rectangleArea += (rec[2] - rec[0]) * (rec[3] - rec[1]);

            // (2) use set to store the four corner points for each rec,
            // if on board, then they will cancel each other,
            // if overlap, there will have redundant points in the set
            // if not overlap and not on board also not the leftMost or rightMost corner points,
            // there will also have redundant points in the set
            // for perfect rectangle, the final set will only have 4 points
            String s1 = rec[0] + " " + rec[1];
            String s2 = rec[0] + " " + rec[3];
            String s3 = rec[2] + " " + rec[1];
            String s4 = rec[2] + " " + rec[3];
            if (!set.add(s1)) set.remove(s1);
            if (!set.add(s2)) set.remove(s2);
            if (!set.add(s3)) set.remove(s3);
            if (!set.add(s4)) set.remove(s4);
        }

        if (!set.contains(leftMostX + " " + leftMostY) || !set.contains(leftMostX + " " + rightMostY) || !set.contains(rightMostX + " " + leftMostY) || !set.contains(rightMostX + " " + rightMostY) || set.size() != 4) return false;
        return rectangleArea == (rightMostX - leftMostX) * (rightMostY - leftMostY);
    }
    private static int calRectangleArea(int[] axis) {
        int leftX = axis[0], leftY = axis[1], rightX = axis[2], rightY = axis[3];
        return (rightX - leftX) * (rightY - leftY);
    }
    private  static boolean checkIfValid (int[][] rectangles) {
        Arrays.sort(rectangles, (int[] a, int[] b) -> a[0] == b[0]? (a[1] == b[1] ? (a[2] == b[2] ? a[3] - b[3]: a[2] - b[2]):a[1] - b[1]): a[0] - b[0]);
        for (int i = 0; i < rectangles.length; i++) {
            for (int j = i; j < rectangles.length; j++) {
                if (rectangles[i][2] > rectangles[j][0] || rectangles[i][3] > rectangles[j][1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int[][] rect = {{1,1,3,3},
//                        {3,1,4,2},
//                        {3,2,4,4},
//                        {1,3,2,4},
//                        {2,3,3,4}};

        int[][] rect = {{0,0,1,1},{0,1,3,2},{1,0,2,2}};
        System.out.println(isRectangleCover(rect));
    }
}
