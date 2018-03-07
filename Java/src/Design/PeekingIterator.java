package Design;

import java.util.Iterator;

/**
 * Created by JMYE on 9/24/16.
 */
public class PeekingIterator implements Iterator<Integer> {
    // Implementation of PeekingIterator that avoids peeking unless necessary.
    private boolean hasPeeked;
    private Integer next;
    private Iterator<Integer> iter;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;


    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!hasPeeked) {
            next = iter.next();
            hasPeeked = true;
        }
        return next;

    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (!hasPeeked) {
            return iter.next();
        }
        Integer rst = next;
        hasPeeked = false;
        next = null;
        return rst;

    }

    @Override
    public boolean hasNext() {
        return hasPeeked || iter.hasNext();
    }

    // solution 2 a little faster
    /*


    private Integer next = null;
    private Iterator<Integer> iter;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        if (iter.hasNext()) {
            next = iter.next();
        }

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;

    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer rst = next;
        next = iter.hasNext() ? iter.next() : null;
        return rst;

    }

    @Override
    public boolean hasNext() {
        return next != null;
    }


     */
}
