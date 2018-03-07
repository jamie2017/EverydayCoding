package DP;

/**
 * Created by JMYE on 9/29/16.
 */
public class Candy {
    public int candy(int[] ratings) {
        // two pass

        if(ratings.length == 0)
            return 0;

        int[] number = new int[ratings.length];

        number[0] = 1;
        // left to right plus 1 by increasing rate
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1])
                number[i] = number[i-1] + 1;
            else
                number[i] = 1;
        }
        int sum = 0;
        // right to left plus 1 by increaseing rate from right
        for(int i = ratings.length-1; i > 0; i--) {
            if(ratings[i] < ratings[i-1] && number[i] >= number[i-1])
                number[i-1] = number[i] + 1;
            sum += number[i];
        }
        sum += number[0];
        return sum;
    }
   /*


   public  int candy(int[] ratings) {
    int pre = 1, countDown = 0, total = 1;
    for (int i = 1; i < ratings.length; i++) {
        if (ratings[i] >= ratings[i - 1]) {
            if (countDown > 0) {
                total += countDown * (countDown + 1) / 2;   // progression part
                if (countDown >= pre) { // check if pre is tall enough
                    total += countDown - pre + 1;
                }
                pre = 1;    // when ascending and there is countDown, prev should be 1
                countDown = 0;
            }
            pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;   // when equals to previous one, set to 1. Else set to prev + 1
            total += pre;
        }
        else {
            countDown++;
        }
    }
    if (countDown > 0) {    // check if there is countDown in the end
        total += countDown * (countDown + 1) / 2;
        if (countDown >= pre) {
            total += countDown - pre + 1;
        }
    }
    return total;
}
    */
}
