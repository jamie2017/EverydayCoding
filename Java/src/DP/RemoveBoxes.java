package DP;

/**
 * Created by JMYE on 3/31/17.
 */
//546. Remove Boxes
    /*
dp[i][j][k] represents the max points from box[i] to box[j] with k boxes whose values equal to box[i]
The transformation function is as below

dp[i][j][k] = max(dp[i+1][m-1][1] + dp[m][j][k+1]) when box[i] = box[m]
     */
public class RemoveBoxes {
    public int removeBoxes(int[] boxes) {
        if (boxes == null || boxes.length == 0) {
            return 0;
        }

        int size = boxes.length;
        int[][][] dp = new int[size][size][size];

        return get(dp, boxes, 0, size-1, 1);
    }

    private int get(int[][][] dp, int[] boxes, int i, int j, int k) {
        if (i > j) {
            return 0;
        } else if (i == j) {
            return k * k;
        } else if (dp[i][j][k] != 0) {
            return dp[i][j][k];
        } else {
            int temp = get(dp, boxes, i + 1, j, 1) + k * k;

            for (int m = i + 1; m <= j; m++) {
                if (boxes[i] == boxes[m]) {
                    temp = Math.max(temp, get(dp, boxes, i + 1, m - 1, 1) + get(dp, boxes, m, j, k + 1));
                }
            }

            dp[i][j][k] = temp;
            return temp;
        }

    }

    public static void main(String[] args) {
        RemoveBoxes test = new RemoveBoxes();
        int[] boxes = new int[]{1, 3, 2, 2, 2, 3, 4, 3, 1};
        System.out.println(test.removeBoxes(boxes));
    }
}
