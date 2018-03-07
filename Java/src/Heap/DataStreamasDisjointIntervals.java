package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by JMYE on 11/13/16.
 */
public class DataStreamasDisjointIntervals {
    private static class Interval {
        int start;
        int end;
        public Interval(){start = 0 ; end = 0;}
        public Interval(int s, int e) {start = s; end = e;}
    }

    TreeMap<Integer, Interval> tree;

    public DataStreamasDisjointIntervals(){
        tree = new TreeMap<>();
    }

    public void addNum (int val) {
        if (tree.containsKey(val)) return;
        Integer l = tree.lowerKey(val);//返回小于指定key的最大map键，如果不存在指定map键，返回null
        Integer h = tree.higherKey(val);
        if (l != null && h != null && tree.get(l).end + 1 == val && h == val + 1) {
            tree.get(l).end = tree.get(h).end;
            tree.remove(h);
        } else if (l != null && tree.get(l).end + 1 >= val) {
            tree.get(l).end = Math.max(tree.get(l).end, val);
        } else if (h != null && h == val + 1) {
            tree.put(val, new Interval(val, tree.get(h).end));
            tree.remove(h);
        } else {
            tree.put(val, new Interval(val, val));
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(tree.values());
    }
}
