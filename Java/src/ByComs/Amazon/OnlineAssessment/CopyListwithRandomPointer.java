package ByComs.Amazon.OnlineAssessment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JMYE on 10/10/16.
 */

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) {this.label = x; }
}
public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        RandomListNode nHead = new RandomListNode(cur.label);
        RandomListNode copy = nHead;
        while(cur != null) {
            if (cur.next != null) {
                copy.next = new RandomListNode(cur.next.label);
            }
            map.put(cur,copy);
            copy.random = cur.random;
            cur = cur.next;
            copy = copy.next;
        }
        copy = nHead;
        while (copy != null) {
            copy.random = map.get(copy.random);
            copy = copy.next;
        }
        return nHead;
    }

}
