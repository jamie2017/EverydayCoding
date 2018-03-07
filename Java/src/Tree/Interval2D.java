package Tree;

/**
 * Created by JMYE on 6/26/17.
 */
/*
  * This class is used to describe 2-D Space
  */
public class Interval2D<Key extends Comparable> {
    public final Interval<Key> intervalX;   // x-interval
    public final Interval<Key> intervalY;   // y-interval

    public Interval2D(Interval<Key> intervalX, Interval<Key> intervalY) {
        this.intervalX = intervalX;
        this.intervalY = intervalY;
    }

    // does this 2D interval a intersect b?
    public boolean intersects(Interval2D<Key> B) {
        if (intervalX.intersects(B.intervalX)) return true;
        if (intervalY.intersects(B.intervalY)) return true;
        return false;
    }

    // does this 2D interval contain (x, y)?
    public boolean contains(Key x, Key y) {
        return intervalX.contains(x) && intervalY.contains(y);
    }

    // return string representation
    public String toString() {
        return intervalX + " x " + intervalY;
    }
}
