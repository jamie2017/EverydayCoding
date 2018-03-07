package DP;

import java.util.*;

/**
 * Created by JMYE on 7/10/17.
 */
public class ShoppingOffers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        List<Integer> offerUsed = new ArrayList<>();
        List<Integer> remains = new ArrayList<>(needs);
        int bestOffers = findBestOffers(special,needs,offerUsed,remains);
        int defaultPrice = 0;
        int remainsPrice = 0;
        for(int i = 0; i < price.size();i++) {
            defaultPrice += price.get(i) * offerUsed.get(i);
            remainsPrice += price.get(i) * remains.get(i);
        }
        return Math.min(bestOffers, defaultPrice) + remainsPrice;
    }

    private int findBestOffers(List<List<Integer>> special, List<Integer> needs, List<Integer> offerUsed, List<Integer> remains) {
        return 1;
    }


    public static void main(String[] args) {
        List<Integer> price = Arrays.asList(2,3,4);
        List<Integer> needs = Arrays.asList(1,2,1);
        List<List<Integer>> special = new ArrayList<>();
        special.add(Arrays.asList(1,1,0,4));
        special.add(Arrays.asList(2,2,1,9));

        ShoppingOffers test = new ShoppingOffers();
        System.out.println(test.shoppingOffers(price,special,needs));

    }
}
