package Stack;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by JMYE on 9/10/16.
 */
public class MinStack {

    // using two build in Java stack to store the stack and min values separately.
    // better way, use one stack with defined class

    static class Element{
        final int value;
        final int min;
        Element(final int value, final int min) {
            this.value = value;
            this.min = min;
        }
    }
    final Stack<Element> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        final int min = (stack.empty())? x:Math.min(stack.peek().min,x);
        stack.push(new Element(x,min));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin(){
        return stack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
