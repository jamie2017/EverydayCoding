package ByComs.WePay;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by JMYE on 8/7/17.
 */
public class Nurikabe {
    final public static int[] DX = {-1,0,0,1};
    final public static int[] DY = {0,-1,1,0};

    // Makes life easier...
    public static int r;
    public static int c;
    public static char[][] grid;
    public static int numValues;
    public static int[][] numList;
    public static int actualOpen;

    public static void main(String[] args) {

        // Get number of cases.
        Scanner stdin = new Scanner(System.in);
        int numCases = stdin.nextInt();

        // Process each case.
        for (int loop=1; loop<=numCases; loop++) {

            // Read in the grid.
            r = stdin.nextInt();
            c = stdin.nextInt();
            numValues = stdin.nextInt();
            grid = new char[r][];
            for (int i=0; i<r; i++)
                grid[i] = stdin.next().toCharArray();

            // Read in the list of numbers.
            numList = new int[numValues][3];
            actualOpen = 0;
            for (int i=0; i<numValues; i++) {
                for (int j=0; j<2; j++)
                    numList[i][j] = stdin.nextInt()-1;
                numList[i][2] = stdin.nextInt();
                actualOpen += numList[i][2];
            }

            // Output result.
            if (solvable())
                System.out.println("Puzzle #"+loop+": Correct");
            else
                System.out.println("Puzzle #"+loop+": Incorrect");
        }
    }

    // Returns if the puzzle is solvable or not.
    public static boolean solvable() {

        // Check sum criterion.
        if (count('.') != actualOpen) return false;

        // Check pool criterion...
        if (pool()) return false;

        // Numbers must be on open squares.
        if (numsFilledIn()) return false;

        // Any floodfill of a '#' should result in reaching all of them.
        int loc = find('#');
        if (loc != -1 && fill(loc) != r*c-actualOpen) return false;

        // Now fill each number square.
        for (int i=0; i<numList.length; i++)
            if (fill(c*numList[i][0]+numList[i][1]) != numList[i][2])
                return false;

        // We made it, it works!
        return true;
    }

    // Returns how many times c is in grid.
    public static int count(char spot) {
        int total = 0;
        for (int i=0; i<r; i++)
            for (int j=0; j<c; j++)
                if (grid[i][j] == spot)
                    total++;
        return total;
    }

    // Returns true iff there is a pool in this puzzle.
    public static boolean pool() {

        // Try each starting upper left corner - it's small so just type them in...
        for (int i=0; i<r-1; i++)
            for (int j=0; j<c-1; j++)
                if (grid[i][j] == '#' && grid[i][j+1] == '#' && grid[i+1][j] == '#' && grid[i+1][j+1] == '#')
                    return true;
        return false;
    }

    // Counts how many squares are filled in.
    public static boolean numsFilledIn() {

        // See if any of the numbers is on an illegal square.
        for (int i=0; i<numList.length; i++)
            if (grid[numList[i][0]][numList[i][1]] == '#')
                return true;
        return false;
    }

    // Returns the lowest index in grid that stores c, in one dimension.
    public static int find(char spot) {

        // Look for c.
        for (int i=0; i<r; i++)
            for (int j=0; j<c; j++)
                if (grid[i][j] == spot)
                    return c*i+j;

        // Should never get here for our purposes - just to make Java happy...
        return -1;
    }

    // Does a floodfill from loc (1D index) on grid on squares with the same character.
    public static int fill(int loc) {

        // Keep track of where we've been.
        boolean[][] used = new boolean[r][c];
        int filled = 0;

        // Get initial location and character.
        int x = loc/c;
        int y = loc%c;
        char fillChar = grid[x][y];
        used[x][y] = true;
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.offer(loc);

        // Run full BFS...
        while (q.size() > 0) {

            // Get next item.
            int cur = q.poll();
            filled++;
            int curX = cur/c;
            int curY = cur%c;

            // Go through neighbors.
            for (int i=0; i<DX.length; i++)	{
                int nextX = curX + DX[i];
                int nextY = curY + DY[i];

                // Must be inbounds, not used and the right character...
                if (!inbounds(nextX, nextY) || used[nextX][nextY] || grid[nextX][nextY] != fillChar) continue;

                // Okay, we fill here.
                q.offer(c*nextX + nextY);
                used[nextX][nextY] = true;
            }
        }

        // Here is our answer.
        return filled;
    }

    // Standard inbounds function.
    public static boolean inbounds(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }
}
