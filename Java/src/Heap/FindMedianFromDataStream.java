package Heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by JMYE on 9/29/16.
 */
public class FindMedianFromDataStream {

    // Think of BST, need to maintain a blance bst
    // Then think of two heap to solve this problem in a better way
    private Queue<Long> small = new PriorityQueue<>(),
                        large = new PriorityQueue<>();

    public void addNum(int num) {
        large.add((long) num); // the top of large is right middle half of stream
        small.add(- large.poll()); // the top of small is the left middle half of steam
        if (large.size() < small.size()) {
            large.add(-small.poll());
        }
    }

    public double findMedian(){
        return large.size() > small.size()
                ? large.peek()
                : (large.peek() - small.peek()) / 2.0;

    }




    class Node {
        int val;
        Node right;
        Node left;
        Node parent;
        public Node(int val){this.val = val;}
    }

    public class MedianFinder {
        Node tree;
        Node medianNode;
        int numElements = 0;
        boolean addedLower = false;

        // Adds a number into the data structure.
        public void addNum(int num) {
            Node newNode = new Node(num);
            addNode(tree, newNode);
            numElements++;
            if (num < medianNode.val){
                addedLower = true;
            } else {
                addedLower = false;
            }
            updateMedianNode();
        }

        // Returns the median of current data stream
        public double findMedian() {
            // even number of elements
            if (numElements % 2 == 0){
                double num1 = medianNode.val;
                double num2 = getNext(medianNode).val;
                return (num1+num2)/2.0;
            }
            // odd number of elements
            return medianNode.val;
        }

        // add node to BST
        private void addNode(Node curr, Node newNode){
            if (curr == null){
                tree = newNode;
                medianNode = tree;
                return;
            }
            if (curr.val > newNode.val){
                if (curr.left == null){
                    curr.left = newNode;
                    curr.left.parent = curr;
                } else {
                    addNode(curr.left, newNode);
                }
            } else if (curr.val <= newNode.val){
                if (curr.right == null){
                    curr.right = newNode;
                    curr.right.parent = curr;
                } else {
                    addNode(curr.right, newNode);
                }
            }
        }

        // keep pointing to median
        private void updateMedianNode(){
            if (numElements == 1){
                return;
            }
            if (addedLower && numElements % 2 == 0){
                medianNode = getPrev(medianNode);
                return;
            }
            if (!addedLower && numElements % 2 == 1){
                medianNode = getNext(medianNode);
            }
        }

        // get the inorder succesor
        private Node getNext(Node curr){
            if (curr.right != null){
                curr = curr.right;
                while (curr.left != null){
                    curr = curr.left;
                }
                return curr;
            } else {
                Node parent = curr.parent;
                while (parent != null && parent.left != curr){
                    curr = parent;
                    parent = curr.parent;
                }
                return parent;
            }

        }

        // get the inorder predecessor
        private Node getPrev(Node curr){
            if (curr.left != null){
                curr = curr.left;
                while (curr.right != null){
                    curr = curr.right;
                }
                return curr;
            } else {
                Node parent = curr.parent;
                while (parent != null && parent.right != curr){
                    curr = parent;
                    parent = curr.parent;
                }
                return parent;
            }
        }
    };

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
}
