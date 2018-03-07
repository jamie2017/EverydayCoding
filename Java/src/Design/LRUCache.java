package Design;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by JMYE on 9/21/16.
 */
public class LRUCache {
    /*
    private Map<Integer, Integer> map;
    private final int CAPACITY;
    public LRUCache(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    public void set(int key, int value) {
        map.put(key, value);
    }
    */

    // Use HashMap to quick find  key
    // Create a double-linked list with prev, next pointer
    // new visited data node will insert in the head of the list
    // if > capacity, delete the data node before the tail
    // Initialize as : head <->tail
    //set(node1,1) : head<->node1<->tail, map.put(node1.key, node1)
    //set(node2,2) : head<->node2<->node1<->tail, map.put(node2.key, node2)

    // Assume capacity = 2, now have 2 nodes in list, if set another node3,
    // then, it will need to delete node1, but can add node3 first
    // set node not yet exists in map:
    // set(node3,3) : head<->node3<->node2<->node1<->tail, node count=3 > 2
    //           >>> head<->node3<->node2<->tail
    // set node that exists in map:
    // set(node2,100): 1) find if node2 in map, then Node n = map.get(node2)
    //                 2) n.value = 100 (modify 2 to 100)
    //                 3) delete node2 from list:head<->node3<->tail
    //                 4) insert modified node after head: head<->node2<->node3<->tail
    private class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
        Node() {
            this(0,0);
        }
    }

    private int capacity,count;
    private Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node n = map.get(key);
        if (n == null) {
            return -1;
        }
        update(n);
        return n.value;
    }

    public void add (int key, int value) {
        Node n = map.get(key);
        if (n == null) {
            n = new Node (key, value);
            map.put(key,n);
            insert(n);
            ++count;
        } else {
            n.value = value;
            update(n);
        }

        if (count > capacity) {
            Node toDel = tail.prev;
            remove(toDel);
            map.remove(toDel.key);
            --count;
        }
    }

    private void update(Node node) {
        remove(node);
        insert(node);
    }

    private void remove(Node node) {
        Node before = node.prev, after = node.next;
        before.next = after;
        after.prev = before;
    }

    private void insert(Node node) {
        Node after = head.next;
        head.next = node;
        node.prev = head;
        node.next = after;
        after.prev = node;
    }
}
