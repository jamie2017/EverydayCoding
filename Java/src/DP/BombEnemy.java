package DP;

/**
 * Created by JMYE on 9/17/16.
 */
public class BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int max = 0;
        int row = 0;
        int[] col = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length;j++) {
                if (grid[i][j] == 'W') continue;
                if(j == 0 || grid[i][j-1] == 'W'){
                    row = killedEnemies(grid, i, j,true);
                }
                if(i == 0 || grid[i-1][j] == 'W'){
                    col[j] = killedEnemies(grid,i,j,false);
                }
                if(grid[i][j] == '0') {
                    max = (row + col[j]) > max ? row + col[j]: max;
                }
            }
        }
        return max;
    }

    private int killedEnemies(char[][] grid, int i, int j, boolean byRow){
        int num = 0;
        if (byRow == true) {
            while(j <= grid[0].length-1 && grid[i][j] != 'W'){
                if(grid[i][j] == 'E') num++;
                j++;
            }
        } else {
            while(i <= grid.length -1 && grid[i][j] != 'W'){
                if(grid[i][j] == 'E') num++;
                i++;
            }
        }

        return num;
    }
}
