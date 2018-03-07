package Math;

/**
 * Created by JMYE on 5/10/17.
 * 573. Squirrel Simulation
 */
public class SquirrelSimulation {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int disSum = 0, maxDiff = Integer.MIN_VALUE;
        for (int[] nut : nuts) {
            int dist = Math.abs(tree[0] - nut[0]) + Math.abs(tree[1] - nut[1]);
            disSum += 2 * dist;
            maxDiff = Math.max(maxDiff, dist - Math.abs(squirrel[0] - nut[0]) - Math.abs(squirrel[1] - nut[1]));
        }
        return disSum - maxDiff;
    }

}
