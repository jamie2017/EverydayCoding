package Tree;

/**
 * Created by JMYE on 6/26/17.
 */
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;


/*************************************************************************
 *  Compilation:  javac QuadTree.java
 *  Execution:    java QuadTree M N
 *
 *  Quad tree.
 *
 *************************************************************************/

public class QuadTree<Key extends Comparable, Value>  {
    private Node root;

    // helper node data type
    private class Node {
        Key x, y;              // x- and y- coordinates
        Node NW, NE, SE, SW;   // four subtrees
        Value value;           // associated data

        Node(Key x, Key y, Value value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    /***********************************************************************
     *  Insert (x, y) into appropriate quadrant
     ***********************************************************************/
    public void insert(Key x, Key y, Value value) {
        root = insert(root, x, y, value);
    }

    private Node insert(Node h, Key x, Key y, Value value) {
        if (h == null) return new Node(x, y, value);
            //// if (eq(x, h.x) && eq(y, h.y)) h.value = value;  // duplicate
        else if ( less(x, h.x) &&  less(y, h.y)) h.SW = insert(h.SW, x, y, value);
        else if ( less(x, h.x) && !less(y, h.y)) h.NW = insert(h.NW, x, y, value);
        else if (!less(x, h.x) &&  less(y, h.y)) h.SE = insert(h.SE, x, y, value);
        else if (!less(x, h.x) && !less(y, h.y)) h.NE = insert(h.NE, x, y, value);
        return h;
    }


    /***********************************************************************
     *  Range search.
     ***********************************************************************/

    public void query2D(Interval2D<Key> rect) {
        query2D(root, rect);
    }

    private void query2D(Node h, Interval2D<Key> rect) {
        if (h == null) return;
        Key xmin = rect.intervalX.low;
        Key ymin = rect.intervalY.low;
        Key xmax = rect.intervalX.high;
        Key ymax = rect.intervalY.high;
        if (rect.contains(h.x, h.y))
            System.out.println("    (" + h.x + ", " + h.y + ") " + h.value + " . . . ");
        if ( less(xmin, h.x) &&  less(ymin, h.y)) query2D(h.SW, rect);
        if ( less(xmin, h.x) && !less(ymax, h.y)) query2D(h.NW, rect);
        if (!less(xmax, h.x) &&  less(ymin, h.y)) query2D(h.SE, rect);
        if (!less(xmax, h.x) && !less(ymax, h.y)) query2D(h.NE, rect);
    }


    /*************************************************************************
     *  helper comparison functions
     *************************************************************************/

    private boolean less(Key k1, Key k2) { return k1.compareTo(k2) <  0; }
    private boolean eq  (Key k1, Key k2) { return k1.compareTo(k2) == 0; }


    /*************************************************************************
     *  test client
     *************************************************************************/
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(){
            public void paint(Graphics g){
                super.paint(g);
                final int[][] search = {
                        {0,0,150,150},
                        {150,0,300,150},
                        {0,150,150,300},
                        {150,150,300,300}
                };
                int N = 2;   // points
                QuadTree<Integer, String> st = new QuadTree<Integer, String>();
                // insert N random points in the unit square
                for (int i = 0; i < N; i++) {
                    Integer x = (int) (300 * Math.random());
                    Integer y = (int) (300 * Math.random());
                    System.out.println("(" + x + ", " + y + ")");
                    st.insert(x, y, "P" + i);
                    g.setColor(Color.red);
                    g.fillOval(x, y, 10, 10);
                    g.drawString("( "+x+" , "+y+" )"+" P"+i, x+5, y+5);
                }
                System.out.println("Done preprocessing " + N + " points");
                // do some range searches
                for (int i = 0; i < search.length; i++) {
                    Integer xmin = search[i][0];
                    Integer ymin = search[i][1];
                    Integer xmax = search[i][2];
                    Integer ymax = search[i][3];
                    Interval<Integer> intX = new Interval<Integer>(xmin, xmax);
                    Interval<Integer> intY = new Interval<Integer>(ymin, ymax);
                    Interval2D<Integer> rect = new Interval2D<Integer>(intX, intY);
                    System.out.println(rect + " : ");
                    st.query2D(rect);
                    g.setColor(Color.blue);
                    g.drawString(rect.toString(), xmin, ymax);
                    g.setColor(Color.black);
                    g.drawRect(xmin, ymin, xmax, ymax);
                }
            }
        };
        panel.setVisible(true);
        frame.add(panel);
    }
}