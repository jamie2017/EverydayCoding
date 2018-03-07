package ByComs.Amazon.OnlineAssessment;

/**
 * Created by JMYE on 10/11/16.
 */

import java.util.*;
class Result {
    int id;
    int value;
    public Result(int id, int value) {
        this.id = id;
        this.value = value;
    }
}

public class FiveScores {
    public static Map<Integer, Double> getHighFive(Result[] rsts) {
        Map<Integer, Double> map = new HashMap<>();
        Map<Integer, List<Integer>> pValue = new HashMap<>();

        for (Result rst : rsts) {
            int id = rst.id;
            if (pValue.containsKey(id)) {
                List<Integer> curL = pValue.get(id);
                curL.add(rst.value);
                pValue.put(id, curL);
            } else {
                List<Integer> curL = new ArrayList<>();
                curL.add(rst.value);
                pValue.put(id, curL);
            }
        }

        for (Integer id : pValue.keySet()) {
            List<Integer> list = pValue.get(id);
            Collections.sort(list, new Comparator<Integer>(){
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });

            // or use
//            Collections.sort(list);
//            Collections.reverse(list);
            // or
//            Collections.sort(list, Collections.reverseOrder());

            double value = 0;
            for (int k = 0; k < 5; k++) {
                value += list.get(k);
            }
            value = value / 5.0;
            map.put(id, value);
        }
        return map;
    }

    public static void main(String[] args) {
        Result r1 = new Result(1, 95);
        Result r2 = new Result(1, 95);
        Result r3 = new Result(1, 91);
        Result r4 = new Result(1, 91);
        Result r5 = new Result(1, 93);
        Result r6 = new Result(1, 105);

        Result r7 = new Result(2, 6);
        Result r8 = new Result(2, 6);
        Result r9 = new Result(2, 7);
        Result r10 = new Result(2, 6);
        Result r11 = new Result(2, 6);
        Result[] arr = {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
        Map<Integer, Double> res = getHighFive(arr);

        System.out.println(res.get(1) + " " +res.get(2));
    }
}
