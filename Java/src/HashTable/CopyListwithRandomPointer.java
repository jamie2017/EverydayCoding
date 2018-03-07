package HashTable;

/**
 * Created by JMYE on 9/16/16.
 */
public class CopyListwithRandomPointer { // MARK
    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode (int x) {this.label = x;}
    }

    /*

    An intuitive solution is to keep a hash table for each node in the list,
    via which we just need to iterate the list in 2 rounds respectively
    to create nodes and assign the values for their random pointers.
    As a result,
    the space complexity of this solution is O(N),
    although with a linear time complexity.
     */


    /*
    The idea is to associate the original node with its copy node in a single linked list.
    In this way, we don't need extra space to keep track of the new nodes.

    1. Iterate the original list and duplicate each node. The duplicate
    of each node follows its original immediately.
    2. Iterate the new list and assign the random pointer for each
    duplicated node.
    3. Restore the original list and extract the duplicated nodes.

     */
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode cur = head, next;

        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        while (cur != null) {
            next = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = next;
            cur = next;
        }

        // Second round: assign random pointers for the copy nodes.
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        cur = head;
        RandomListNode dummyHead = new RandomListNode(0);
        RandomListNode copy = dummyHead;
        while (cur != null) {
            next = cur.next.next;
            copy.next = cur.next; // extract the copy
            copy = copy.next;
            cur.next = next;// restore the original list
            cur = next;
        }

        return dummyHead.next;
    }
}
