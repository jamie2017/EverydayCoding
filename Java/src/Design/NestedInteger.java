package Design;

import java.util.List;

/**
 * Created by JMYE on 9/25/16.
 */
public class NestedInteger {

    // Constructor initializes an empty nested list.
    public NestedInteger(){

    }

    public NestedInteger(int n) {

    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return true;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return null;
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return null;
    }

    // Set this NestedInteger to hold a single integer.
   public void setInteger(int value) {
       return;
   }

   // Set this NestedInteger to hold a nested list and adds a nested integer to it.
   public void add(NestedInteger ni){
       return;
   }
}