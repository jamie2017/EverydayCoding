package DP;

/**
 * Created by JMYE on 11/13/16.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int accumulate = 0;
        int minaccu = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            accumulate += gas[i] - cost[i];
            if (accumulate < minaccu) {
                minaccu = accumulate;
                start = i + 1;
            }
        }
        if (accumulate < 0) {
            return -1;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] gas = {4,6,4,13};
        int[] cost = {5,7,6,2};
        GasStation test = new GasStation();
        System.out.println(test.canCompleteCircuit(gas,cost));
    }
}
