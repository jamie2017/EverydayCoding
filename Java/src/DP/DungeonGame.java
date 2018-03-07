package DP;

/**
 * Created by JMYE on 7/6/17.
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int m = dungeon.length, n = dungeon[0].length;
        int[][] health = new int[m][n];
        health[m - 1][n - 1] = Math.max(1, -dungeon[m - 1][n - 1] + 1);
        for (int i = m - 2; i >= 0; i--) {
            health[i][n - 1] = Math.max(1,health[i + 1][n - 1] - dungeon[i][n - 1]);
        }
        for (int j = n - 2; j >= 0; j--) {
            health[m - 1][j] = Math.max(1, health[m - 1][j + 1] - dungeon[m - 1][j]);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(1, health[i + 1][j] - dungeon[i][j]);
                int right = Math.max(1, health[i][j + 1] - dungeon[i][j]);
                health[i][j] = Math.min(right,down);
            }
        }
        return health[0][0];
    }

    public static void main(String[] args) {
        DungeonGame test = new DungeonGame();
        int[][] dungeon = {{-2,-3,3},{-5,10,1},{10,30,-5}};
        System.out.println(test.calculateMinimumHP(dungeon)); // 6 path of [-2.-3.10,30]
        int[][] dungeon2 = {{2},{1}};
        System.out.println(test.calculateMinimumHP(dungeon2)); // 1
        int[][] dungeon3 = {{-2,-3,3},
                            {-5,10,1},
                            {10,30,-11}};
        System.out.println(test.calculateMinimumHP(dungeon3)); // 6

    }
}
