package DP;

/**
 * Created by JMYE on 9/17/16.
 */
public class BestTimetoBuyandSellStockwithCooldown { // SMART

    /*

    buy[i]  = max(rest[i-1]-price, buy[i-1])
    sell[i] = max(buy[i-1]+price, sell[i-1])
    rest[i] = max(sell[i-1], buy[i-1], rest[i-1])

    (1) We have to `rest` before we `buy` and
    (2) we have to `buy` before we `sell`
    One tricky point is how do you make sure you sell before you buy, since from the equations it seems that [buy, rest, buy] is entirely possible.

    Well, the answer lies within the fact that buy[i] <= rest[i] which means rest[i] = max(sell[i-1], rest[i-1]). That made sure [buy, rest, buy] is never occurred.

    A further observation is that and rest[i] <= sell[i] is also true therefore

    rest[i] = sell[i-1]
    Substitute this in to buy[i] we now have 2 functions instead of 3:

    buy[i] = max(sell[i-2]-price, buy[i-1])
    sell[i] = max(buy[i-1]+price, sell[i-1])
     */
    public int maxProfit(int[] prices) {
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
            System.out.println("Price: " + price +" buy: "+buy+" sell: "+sell);
        }
        return sell;
    }
    public static void main(String[] argu) {
        int[] prices = {1,2,3,0,2};
        BestTimetoBuyandSellStockwithCooldown test = new BestTimetoBuyandSellStockwithCooldown();
        System.out.println(test.maxProfit(prices));
    }
}
