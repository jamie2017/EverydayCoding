package ByComs.Yelp;

import java.util.*;


    /**
     * Created by JMYE on 11/3/16.
     */
    public class DinnerDecision {
        public static String findingResturant(String[] l1, String[] l2) {

            if (l1 == null || l2 == null) return "Yelpwich";

            Map<String, Integer> tmpMap = new HashMap<>();

            Set<String> checkIfHasComm = new HashSet();

            for (int i = 0; i < l1.length; i++) {
                tmpMap.put(l1[i],i);
            }

            for (int i = 0; i < l2.length; i++) {
                if (tmpMap.containsKey(l2[i])) {
                    checkIfHasComm.add(l2[i]);
                    tmpMap.put(l2[i],tmpMap.get(l2[i]) + i);
                }
            }
            if (checkIfHasComm.size() == 0) return "YelpWich";

            Map<Integer, String> targetMap = new HashMap<>();

            for (String key : tmpMap.keySet()) {
                if (checkIfHasComm.contains(key)) {
                    int tmpVal = tmpMap.get(key);
                   if (!targetMap.containsKey(tmpVal)) {
                       targetMap.put(tmpVal,key);
                   } else {
                       targetMap.remove(tmpVal);
                   }
                }
            }
            if (targetMap.size() == 0) return "YelpWich";


            int target = Integer.MAX_VALUE;
            for (int key : targetMap.keySet()) {
                target = Math.min(target, key);
            }
            return targetMap.get(target);

        }


        public static String findingResturant2(String[] arr1, String[] arr2) {
            int minCombinedRank = arr1.length + arr2.length;
            String res = null;
            Map<String, Integer> rankMap = new HashMap<>();
            int rank;
            for (int i = 0; i < arr1.length; i++) {
                rankMap.put(arr1[i], i);
            }
            for (int i = 0; i < arr2.length; i++) {
                if (rankMap.containsKey(arr2[i])) {
                    rank = rankMap.get(arr2[i]) + i;
                    if (rank < minCombinedRank) {
                        minCombinedRank = rank;
                        res = arr2[i];
                    }
                }
            }
            return res == null ? "Yelpwich" : res;
        }
        public static void main(String[] args) {
        String[] l1 = {"KFC","Pizza", "Noodle"};
        String[] l2 = {"Noodle","Pizza"};
        System.out.println(findingResturant(l1,l2));
            System.out.println(findingResturant2(l1,l2));
    }

}
