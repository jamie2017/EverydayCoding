package ByComs.Yelp;

import java.util.*;

/**
 * Created by JMYE on 11/2/16.
 */
public class FindResturant {
    public static class BussinessInfo{
        int id;
        List<String> category;
    }



    public static List<Integer> findResturant (List<BussinessInfo> input) {

        List<Integer> rst = new ArrayList<>();
        if (input == null || input.size() == 0) return rst;

        for (BussinessInfo bi : input) {
            int count = 0;
            for (String str : bi.category) {
                if (str.equals("japanese") || str.equals("resturant")) count++;
            }
            if(count == 2) rst.add(bi.id);
        }
        return rst;

    }


    public static void main(String[] args) {
        List<BussinessInfo> input = new ArrayList<>();
        BussinessInfo i1 = new BussinessInfo();
        i1.id = 101;
        i1.category = new ArrayList<>(Arrays.asList("japanese","sushi","resturant"));
        input.add(i1);

        BussinessInfo i2 = new BussinessInfo();
        i2.id = 102;
        i2.category = new ArrayList<>(Arrays.asList("japanese","seafood"));
        input.add(i2);

        BussinessInfo i3 = new BussinessInfo();
        i3.id = 103;
        i3.category = new ArrayList<>(Arrays.asList("japanese","ramen","resturant"));
        input.add(i3);

        System.out.println(findResturant(input));

    }
}
