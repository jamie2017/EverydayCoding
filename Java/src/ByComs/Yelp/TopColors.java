package ByComs.Yelp;

import java.util.*;

/**
 * Created by JMYE on 11/2/16.
 */
public class TopColors {
    public static List<String> topColors(List<List<String>> colors) {

        if (colors == null || colors.size() == 0) return  new ArrayList<>();
        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, List<String>> map2 = new HashMap<>();

        for (int i = 0; i < colors.size(); i++) {
            for (int j = 0; j < colors.get(i).size();j++) {
                if (!map1.containsKey(colors.get(i).get(j))) {
                    map1.put(colors.get(i).get(j), 1);
                } else {
                    int tmp = map1.get(colors.get(i).get(j)) + 1;
                    map1.put(colors.get(i).get(j), tmp);
                }
            }
        }
        int maxCount = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            int val = entry.getValue();
            String key = entry.getKey();
            if (!map2.containsKey(val)) {
                map2.put(val, new ArrayList<>());
                map2.get(val).add(key);
            } else {
                map2.get(val).add(key);
            }
            maxCount = Math.max(maxCount,val);
        }

        List<String> rst = map2.get(maxCount);
        Collections.sort(rst);
        return rst;
    }


    public static List<String> topColors2(List<List<String>> matrix) {
        int maxCnt  = 0;
        int cnt = 0;
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (List<String> ls : matrix) {
            for (String c : ls) {
                if (map.containsKey(c)) {
                    cnt = map.get(c) + 1;
                } else {
                    cnt = 1;
                }
                map.put(c, cnt);
                if (cnt > maxCnt) {
                    maxCnt = cnt;
                    res.clear();
                    res.add(c);
                } else if (cnt == maxCnt) {
                    res.add(c);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
    public static void main(String[] args) {
        // test cast 1
//        List<String> row1 = new ArrayList<>(Arrays.asList("red","red","green"));
//        List<String> row2 = new ArrayList<>(Arrays.asList("black","blue","black"));
//        List<String> row3 = new ArrayList<>(Arrays.asList("red","yellow","yellow"));

//        List<String> row1 = new ArrayList<>(Arrays.asList("red","green","green"));
//        List<String> row2 = new ArrayList<>(Arrays.asList("black","blue","black"));
//        List<String> row3 = new ArrayList<>(Arrays.asList("red","yellow","yellow"));


        List<String> row1 = new ArrayList<>(Arrays.asList("r", "g", "g"));
        List<String> row2 = new ArrayList<>(Arrays.asList("black", "b", "black"));
        List<String> row3 = new ArrayList<>(Arrays.asList("r", "y", "y", "grey"));

        List<List<String>> tests = new ArrayList<>();
        tests.add(row1);
        tests.add(row2);
        tests.add(row3);

        List<String> rst = topColors(tests);
        System.out.println(rst);
        List<String> rst2 = topColors2(tests);
        System.out.println(rst2);


    }
}
