package DP;

/**
 * Created by JMYE on 9/19/16.
 */
public class BestTimetoBuyandSellStockIV {//MARK

    public int maxProfit(int k, int[] prices) {
        if ( k < 1 ){
            return 0;
        }

        if ( prices == null || prices.length <= 1 ){
            return 0;
        }

        //when k >= prices.length/2 >> equals to problem of unlimited transactions
        if ( k >= prices.length/2 ){
            int profit = 0;
            for (int i = 1; i < prices.length; i++){
                if (prices[i] > prices[i-1] ){
                    profit += prices[i] - prices[i-1];
                }
            }
            return profit;
        }

        //DP for at most k trades
        int[] buy = new int[k+1];
        int[] sell = new int[k+1];

        for (int i = 0; i <= k; i++){
            buy[i] = Integer.MIN_VALUE;
            sell[i] = 0;
        }

        for (int i = 0; i < prices.length; i++){
            for (int j = 1; j < k + 1; j++){
                buy[j] = Math.max(buy[j], sell[j-1] - prices[i]);
                sell[j] = Math.max(sell[j], prices[i] + buy[j]);
            }
        }

        return sell[k];
    }
}
