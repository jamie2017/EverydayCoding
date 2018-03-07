package ByComs.SumoLogic;

import java.util.*;

/**
 * Created by JMYE on 7/5/17.
 Design a data structure which has following operations:

 1. void add(e)
 2. void delete(e)
 3. boolean contains(e)
 4. e getRandom()
 5. e getMostRecent()

 All operations should be preferably O(1)

 设计一个数据结构实现get(key), put(key, value), delete(key)和getLast()来存放k-v对。
 这个getLast返回的是上一次操作的k-v对，但是删除的操作不算，因为删除的k－v已经不在数据结构里了。
 */
class Element{
    int K,V;
    public Element(){}
    public Element(int K, int V) {
        this.K = K;
        this.V = V;
    }
}
public class BigOOneOperations {
    Map<Integer, Integer> map;
    List<Element> valList;
    Stack<Integer> mostRecentStack;

    public BigOOneOperations() {
        map = new HashMap<>();
        valList = new ArrayList<>();
        mostRecentStack = new Stack<>();
    }
    public void add(int k,int v) { // O(1)
        if (!map.containsKey(k)) {
            valList.add(new Element(k,v));
            map.put(k,valList.size() - 1);
        } else {
            int idx = map.get(k);
            valList.set(idx,new Element(k,v));
        }
        mostRecentStack.push(k);

    }

    public Element get(int k) { // O(1)
        if (!map.containsKey(k)){
            return null;
        }
        mostRecentStack.push(k);
        int idx = map.get(k);
        return valList.get(idx);
    }

    public void delete(int k) { // O(1)
        if (!map.containsKey(k)) {
            return;
        }
        int idx = map.get(k);
        Element lastElement = valList.get(valList.size() - 1);
        valList.set(idx,lastElement);
        map.put(lastElement.K,idx);
        valList.remove(valList.size() - 1);
        map.remove(k);
    }

    public Element getRandom() {
        Random randomGenerator = new Random();
        int ranIdx = randomGenerator.nextInt(valList.size() - 1);
        Element ranElement = valList.get(ranIdx);
        mostRecentStack.push(ranElement.K);
        return ranElement;
    }

    public Element getMostRecent(){
        while (!mostRecentStack.isEmpty() && !map.containsKey(mostRecentStack.peek())){
            mostRecentStack.pop();
        }
        if (mostRecentStack.isEmpty()) {
            return null;
        }
        int lastK = mostRecentStack.peek();
        return valList.get(map.get(lastK));
    }

    public static void main(String[] args) {
        BigOOneOperations test = new BigOOneOperations();
        test.add(101,510);
        test.add(102,520);
        test.add(103,530);
        System.out.println(test.get(101).V);
        System.out.println(test.get(102).V);
        test.add(102,522);
        System.out.println(test.get(102).V);
        System.out.println();

        test.add(104,540);
        test.add(105,550);
        Element m1 = test.getMostRecent();
        System.out.println("Most Recent: "+m1.K +", " + m1.V);
        Element r1 = test.getRandom();
        System.out.println("Random: " + r1.K + ", "+r1.V);
        Element m2 = test.getMostRecent();
        System.out.println("Most Recent: "+m2.K +", " + m2.V);
        test.delete(r1.K);
        System.out.println("Delete " + r1.K);
        Element m3 = test.getMostRecent();
        System.out.println("Most Recent: "+m3.K +", " + m3.V);
//        System.out.println(test.mostRecentStack);
        Element r2 = test.getRandom();
        System.out.println("Random: " + r2.K + ", "+r2.V);
        Element m4 = test.getMostRecent();
        System.out.println("Most Recent: "+m4.K +", " + m4.V);
//        System.out.println(test.mostRecentStack);

        Element r3 = test.getRandom();
        System.out.println("Random: " + r3.K + ", "+r3.V);
        Element m5 = test.getMostRecent();
        System.out.println("Most Recent: "+m5.K +", " + m5.V);
        System.out.println(test.mostRecentStack);
        test.delete(m5.K);
        System.out.println("Delete " + m5.K);
        Element m6 = test.getMostRecent();
        System.out.println("Most Recent: "+m6.K +", " + m6.V);
        System.out.println(test.mostRecentStack);
        test.delete(m6.K);
        System.out.println("Delete " + m6.K);
        Element m7 = test.getMostRecent();
        if (m7 == null) {
            System.out.println("Stack is empty!");
        } else {
            System.out.println("Most Recent: "+m7.K +", " + m7.V);
        }
        System.out.println(test.mostRecentStack);
        test.delete(m7.K);
        System.out.println("Delete " + m7.K);
        Element m8 = test.getMostRecent();
        if (m8 == null) {
            System.out.println("Stack is empty!");
        } else {
            System.out.println("Most Recent: "+m8.K +", " + m8.V);
        }
        System.out.println(test.mostRecentStack);
        test.delete(m8.K);
        System.out.println("Delete " + m8.K);
        Element m9 = test.getMostRecent();
        if (m9 == null) {
            System.out.println("Stack is empty!");
        } else {
            System.out.println("Most Recent: "+m9.K +", " + m9.V);
        }
        System.out.println(test.mostRecentStack);







    }


}
