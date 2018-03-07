package ByComs.SumoLogic;

import com.sun.org.apache.xalan.internal.lib.ExsltSets;

import java.util.*;

import static java.util.Arrays.asList;

/**
 * Created by JMYE on 6/23/17.
 * given a list of sets，find all pair of sets having any intersection
 */
public class IntersectionPairSet {
    static class Pair {
        Set<Integer> i,j;
        public Pair(Set<Integer> i, Set<Integer> j) {
            this.i = i;
            this.j = j;
        }
        public String toString(){
            String s1 = Arrays.toString(i.toArray(new Integer[i.size()]));
            String s2 = Arrays.toString(j.toArray(new Integer[j.size()]));
            return s1 + " intersection with " + s2;

        }
    }

    public List<Pair> findAllPairOfIntersectionSet(List<Set<Integer>> setList) { // O(n*n*m)
        List<Pair> pairList = new ArrayList<>();
        Collections.sort(setList, (Set s1, Set s2)-> s1.size() - s2.size());
        for (int i = 0; i < setList.size() - 1; i++) {
            for (int j = i + 1; j < setList.size();j++) {
                for (Integer ik: setList.get(i)) {
                    if (setList.get(j).contains(ik)) {
                        pairList.add(new Pair(setList.get(i), setList.get(j)));
                        break;
                    }
                }
            }
        }
        return pairList;
    }

    public List<Pair> findAllPairOfIntersectionSet2(List<Set<Integer>> setList) {
        List<Pair> pairList = new ArrayList<>();
        for (int i = 0; i < setList.size() - 1; i++) {
            for (int j = i + 1; j < setList.size();j++) {
                Set intersetPairs = new HashSet(setList.get(i));// O(n)
                intersetPairs.retainAll(setList.get(j)); // O(n)
                if (intersetPairs.size() > 0) {
                    pairList.add(new Pair(setList.get(i), setList.get(j)));
                }
//                Iterator it = intersetPairs.iterator();
//                while (it.hasNext()) {
//                    System.out.print(it.next() +", ");
//                }
//                System.out.println();
            }
        }
        return pairList;
    }
    public static void main(String[] args) {
        IntersectionPairSet test = new IntersectionPairSet();
        List<Set<Integer>> sets = new ArrayList<>();
        sets.add(new HashSet(asList(new Integer[]{1,2,3})));
        sets.add(new HashSet(asList(new Integer[]{2,3,6})));
        sets.add(new HashSet(asList(new Integer[]{11,22,33})));
        sets.add(new HashSet(asList(new Integer[]{11,2,3})));
        sets.add(new HashSet(asList(new Integer[]{1,22,3})));
        List<Pair> pairs = test.findAllPairOfIntersectionSet(sets);
        for (Pair p:pairs) {
            System.out.println(p.toString());
        }

        System.out.println("-----------");
        List<Pair> pairs2 = test.findAllPairOfIntersectionSet2(sets);
        for (Pair p:pairs2) {
            System.out.println(p.toString());
        }
        System.out.println("-----------");

    }
}
