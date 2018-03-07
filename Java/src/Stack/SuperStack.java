package Stack;

import java.util.Stack;

/**
 * Created by JMYE on 7/17/17.
 */
public class SuperStack {
    Stack<int[]> stk;
    public SuperStack() {
        stk = new Stack<>();
    }
    public void append(int x){
        stk.add(new int[]{x,0});
    }
    public int pop() {
        int[] nodeArray = stk.pop();
        if (!stk.isEmpty()) {
            stk.peek()[1] += nodeArray[1];
        }
        return nodeArray[0] + nodeArray[1];
    }

    public void addAcross(int x) {
        if (!stk.isEmpty()) {
            stk.peek()[1] += x;
        }
    }

    public static void main(String[] args) {
        SuperStack test = new SuperStack();
        test.append(1);
        test.append(2);
        test.append(3);
        test.append(4);
        System.out.println(test.pop());
        test.append(5);
        System.out.println(test.pop());
        test.addAcross(1000);
        while(!test.stk.isEmpty()) {
            System.out.println(test.pop());
        }
        test.append(0);
        System.out.println(test.pop());


    }
}


