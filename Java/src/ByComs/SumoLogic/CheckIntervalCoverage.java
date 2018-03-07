package ByComs.SumoLogic;

import java.util.*;

/**
 * Created by JMYE on 6/16/17.
 * List of intervals: [1,3], [4,10], [20,30].
 * check if given interval like [5,10] are occupied by the intervals.
 */

class Interval {
    int start,end;
    public Interval(int start,int end){
        this.start=start;
        this.end=end;
    }
}
public class CheckIntervalCoverage {
    // solution 1
    public boolean checkIntervalCoverage(List<Interval> A, Interval B) { // O(nlgn) O(1)
        Collections.sort(A, (Interval i1, Interval i2)-> i1.start != i2.start? i1.start - i2.start:i1.end - i2.end);
        int i = 0;
        int maxReach = -1;
        int start = B.start, end = B.end;
        while (i < A.size() && maxReach < end) {
            if (A.get(i).end <= start) {
                i ++;
            } else {
                if (A.get(i).start > start) {
                    break;
                }
                while (i < A.size() && maxReach < end && A.get(i).start <= start) {
                    if (A.get(i).end > maxReach) {
                        maxReach = A.get(i).end;
                    }
                    i++;
                }
                start = maxReach;
            }
        }
        if (maxReach == -1 || maxReach < end) {
            return false;
        }
        return true;

    }
    // solution 2
    public boolean checkIntervalCoverageOpt(List<Interval> A, Interval B) { // O(nm) O(m)
        Map<Integer,Boolean> coverMap = new HashMap<>();
        for (int i = B.start; i < B.end; i++) {
            coverMap.put(i,false);
        }
        for (int i = B.start, j = B.start; i < B.end; i++) {
            for (Interval it : A) {
                if (it.start <= i && i < it.end) {
                    j = Math.max(j, i + (it.end - it.start));
                    if (j > i) {
                        break;
                    }
                }
            }
            coverMap.put(i, j > i);
        }

        for(Integer key: coverMap.keySet()) {
            if (!coverMap.get(key)) {
                return false;
            }
        }
        return true;
    }

    // solution 3 if the freq of query is way more than insert interval
    public boolean checkIntervalCoverageBySet(List<Interval> A, Interval B) { // O(nk) O(k）
        Set<Integer> coverSet = findCoverSet(A);
        return findIfCover(coverSet,B);
    }

    private Set<Integer> findCoverSet(List<Interval> A) {
        Set<Integer> coverSet = new HashSet<>();
        for (Interval i : A) {
            for(int j = i.start; j < i.end; j++) {
                coverSet.add(j);
            }
        }
        return coverSet;
    }
    private Boolean findIfCover(Set<Integer> coverSet, Interval B) {
        for (int k = B.start; k < B.end; k++) {
            if (!coverSet.contains(k)) {
                return false;
            }
        }
        return true;
    }

    public Boolean checkIfFullCoverBySet(List<Interval> A, int size) {
        Set<Integer> coverSet = findCoverSet(A);
        return coverSet.size() == size;
    }

    public Boolean checkIfFullCoverByMerge(List<Interval> A, int size) {
        Collections.sort(A, (Interval a1,Interval a2)-> a1.start == a2.start? a1.end - a2.end:a1.start - a2.start);
        int totalCover = 0;
        int curLeft = A.get(0).start, curRight = A.get(0).end;
        for (int i = 1; i < A.size(); i++) {
            if (curRight > A.get(i).start) {
                curLeft = Math.min(curLeft,A.get(i).start);
                curRight = Math.max(curRight,A.get(i).end);
            } else {
                totalCover += curRight - curLeft;
                curLeft = A.get(i).start;
                curRight = A.get(i).end;
            }
        }
        totalCover += curRight - curLeft;
        return totalCover == size;
    }


    public static void main(String[] args) {
        CheckIntervalCoverage test = new CheckIntervalCoverage();
        List<Interval> A = Arrays.asList(new Interval(1,3),new Interval(4,10),new Interval(20,30));
        Interval B = new Interval(5,10);
        System.out.println(test.checkIntervalCoverage(A,B) + " " +test.checkIntervalCoverageBySet(A,B) + " " + test.checkIntervalCoverageOpt(A,B));
//        System.out.println(test.checkIfFullCoverByMerge(A,30)+ " < > " + test.checkIfFullCoverBySet(A, 30));
        A = Arrays.asList(new Interval(13,25),new Interval(0,5),new Interval(4,20),new Interval(5,15),new Interval(6,21));
        B = new Interval(6,24);
        System.out.println(test.checkIntervalCoverage(A,B) + " " +test.checkIntervalCoverageBySet(A,B)+ " " + test.checkIntervalCoverageOpt(A,B));
//        System.out.println(test.checkIfFullCoverByMerge(A,25) + " < > " + test.checkIfFullCoverBySet(A, 25));
        A = Arrays.asList(new Interval(0,4),new Interval(4,6),new Interval(7,9),new Interval(5,9));
        B = new Interval(3,9);
        System.out.println(test.checkIntervalCoverage(A,B) + " " +test.checkIntervalCoverageBySet(A,B)+ " " + test.checkIntervalCoverageOpt(A,B));
//        System.out.println(test.checkIfFullCoverByMerge(A,9)+ " < > " + test.checkIfFullCoverBySet(A, 9));
        A = Arrays.asList(new Interval(0,3),new Interval(2,7),new Interval(3,4),new Interval(4,6));
        B = new Interval(0,6);
        System.out.println(test.checkIntervalCoverage(A,B) + " " +test.checkIntervalCoverageBySet(A,B)+ " " + test.checkIntervalCoverageOpt(A,B));
        B = new Interval(-2,2);
        System.out.println(test.checkIntervalCoverage(A,B) + " " +test.checkIntervalCoverageBySet(A,B)+ " " + test.checkIntervalCoverageOpt(A,B));
        B = new Interval(5,7);
        System.out.println(test.checkIntervalCoverage(A,B) + " " +test.checkIntervalCoverageBySet(A,B)+ " " + test.checkIntervalCoverageOpt(A,B));
//        System.out.println(test.checkIfFullCoverByMerge(A,7)+ " < > " + test.checkIfFullCoverBySet(A, 7));
    }
}
