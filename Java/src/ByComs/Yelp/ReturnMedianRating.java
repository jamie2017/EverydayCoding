package ByComs.Yelp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by JMYE on 11/2/16.
 */
public class ReturnMedianRating {
    public static class CustomerRating{
        int id;
        int rating;
        public CustomerRating (int id, int rating){
            this.id = id;
            this.rating = rating;
        }
    }

    public static double returnMedianRating(List<CustomerRating> customerRatings) {
        int len = customerRatings.size();
        if (len % 2 == 1) {
            return medianRating(customerRatings, len / 2 + 1) / 1.0;
        } else {
            return (medianRating(customerRatings, len / 2) + medianRating(customerRatings, len / 2 + 1))/2.0;
        }
    }

    private static int medianRating(List<CustomerRating> customerRatings, int median) {
//        customerRatings.sort(new Comparator<CustomerRating>(){
//                @Override
//                public int compare(CustomerRating o1, CustomerRating o2) {
//                    return o1.rating - o2.rating;
//                }
//            });
//        customerRatings.sort((CustomerRating o1, CustomerRating o2)->o1.rating - o2.rating);
//        customerRatings.sort((o1, o2)->o1.rating - o2.rating);



        return customerRatings.get(median - 1).rating;
    }


    public static void main(String[] args) {
        List<CustomerRating> tests = new ArrayList<>();
        tests.add(new CustomerRating(101,5));
        tests.add(new CustomerRating(102,2));
        tests.add(new CustomerRating(103,3));
        tests.add(new CustomerRating(104,4));
        tests.add(new CustomerRating(105,5));

        System.out.println(returnMedianRating(tests));
    }
}
