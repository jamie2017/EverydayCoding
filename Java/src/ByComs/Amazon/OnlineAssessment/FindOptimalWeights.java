package ByComs.Amazon.OnlineAssessment;

import java.util.Arrays;

/**
 * Created by JMYE on 10/9/16.
 */
/*

要求在array中选出两个weights總总和小于等于capacity但最接近capacity 然後指定到一個Container object並且return。
 */


public class FindOptimalWeights {
    class Container {
        public double first;
        public double second;
        public Container(double first, double second) {
            this.first = first;
            this.second = second;
        }
    }
    public  Container findOptimalWeights(double capacity, double[] weights){
        double maxWei = 0;
        double maxSmall = 0;
        double maxLarge = 0;
        Container con = new Container(maxSmall, maxLarge);

        Arrays.sort(weights);
        int i = 0;
        int j = weights.length - 1;
        while (i < j) {
            if (weights[i] + weights[j] < capacity) {
                if (weights[i] + weights[j] > maxWei) {
                    maxWei = weights[i] + weights[j];
                    con.first = weights[i];
                    con.second = weights[j];
                }
                i++;
            } else if (weights[i] + weights[j] == capacity) {
                con.first = weights[i];
                con.second = weights[j];
                maxWei = capacity;
                break;
            } else {
                j--;
            }
        }
        return con;
    }

    public static void main (String[] args) {
        double capacity = 35;
        double[] weights = {10,24,30,9,19,23,7};
        FindOptimalWeights test = new FindOptimalWeights();
        Container rst = test.findOptimalWeights(capacity,weights);
        System.out.println(rst.first);
        System.out.println(rst.second);
    }
}
