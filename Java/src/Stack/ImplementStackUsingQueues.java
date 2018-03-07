package Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by JMYE on 5/10/17.
 */
public class ImplementStackUsingQueues {
    private Queue<Integer> queue = new LinkedList<>();

    public ImplementStackUsingQueues(LinkedList<Integer> queue) {
        this.queue = queue;
    }

    public void push(int x) {
        queue.offer(x);
        int sz = queue.size();
        while (sz > 1) {
            queue.add(queue.poll());
            sz--;
        }
    }

    public void pop(){
        queue.poll();
    }

    public int top(){
        return queue.peek();
    }

    public boolean empty(){
        return queue.isEmpty();
    }
}
/*
[1,2]
push(3)
[1,2,3]->[3,2,1]

 */