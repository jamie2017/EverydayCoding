package Design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by JMYE on 9/25/16.
 */
public class Vector2D implements Iterator<Integer> {
    Iterator<List<Integer>> iter1;// input 2d
    Iterator<Integer> iter2; // each 1d in 2d

    public Vector2D(List<List<Integer>> vec2d) {
        iter1 = vec2d.iterator();
        iter2 = new ArrayList<Integer>().iterator();
        while (!iter2.hasNext() && iter1.hasNext()) {
            iter2 = iter1.next().iterator();
        }
    }

    @Override
    public Integer next() {
        Integer i = iter2.next();
        while (!iter2.hasNext() && iter1.hasNext()) {
            iter2 = iter1.next().iterator();
        }
        return i;
    }

    @Override
    public boolean hasNext() {
        return iter2.hasNext();
    }

    public static void main (String[] args) {
        List<List<Integer>> vec2d = Arrays.asList(
                                    Arrays.asList(1,2),
                                    Arrays.asList(3),
                                    Arrays.asList(4,5,6)
                                    );

        Vector2D i = new Vector2D(vec2d);
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}


/*
// solution 2: not using Iterator

public class Vector2D implements Iterator<Integer> {
    int row, col;
    List<List<Integer>> vec2d;
    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        row = 0;
        col = 0;
    }

    @Override
    public Integer next() {
        col++;
        return vec2d.get(row).get(col - 1);

    }

    @Override
    public boolean hasNext() {
        while (row < vec2d.size() && col >= vec2d.get(row).size()) {
            row++;
            col = 0;
        }
        return row < vec2d.size();
    }
}



 */
/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
