package Design;

import java.util.Iterator;
import java.util.List;

/**
 * Created by JMYE on 9/18/16.
 */
public class ZigzagIterator {
    // swich between two vectors

    private Iterator<Integer> i, j, tmp;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        i = v2.iterator();
        j = v1.iterator();
    }

    public int next() {
        if (j.hasNext()) { tmp = j; j = i; i = tmp; }
        return i.next();
    }

    public boolean hasNext() {
        return i.hasNext() || j.hasNext();
    }
}

// Easy to extend to k vector by solution below
/*
    Queue<Iterator> q;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        q = new LinkedList();
        if (!v1.isEmpty()) q.offer(v1.iterator());
        if (!v2.isEmpty()) q.offer(v2.iterator());
    }

    public int next() {
        Iterator cur = q.poll();
        int res = (int) cur.next();
        if (cur.hasNext()) q.offer(cur);
        return res;
    }

    public boolean hasNext() {
        return q.peek() != null;
    }

 */

/*

 Iterator<Integer>[] its;
    int pos;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        its = new Iterator[]{v1.iterator(), v2.iterator()};
        pos = 0;
    }

    public int next() {
        int next = its[pos].next();
        pos = (pos == its.length - 1) ? 0 : pos + 1;
        return next;
    }

    public boolean hasNext() {
        if (its[pos].hasNext()) return true;
        for (int i = pos + 1; i < its.length; i++) {
            if (its[i].hasNext()) {
                pos = i;
                return true;
            }
        }
        for (int i = 0; i < pos; i++) {
            if (its[i].hasNext()) {
                pos = i;
                return true;
            }
        }
        return false;
    }
 */