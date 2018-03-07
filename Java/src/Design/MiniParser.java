package Design;

/**
 * Created by JMYE on 9/25/16.
 */


import java.util.Stack;

/*
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * /

 public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

public class MiniParser {  // MARK
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }
        Stack<NestedInteger> stk = new Stack<>();
        StringBuilder num = new StringBuilder();
        for (int i = 0; i <  s.length(); i++) {
            switch (s.charAt(i)) {
                case '[':
                    stk.push(new NestedInteger());
                    break;
                case ',':
                    if (num.length() != 0) {
                        stk.peek().add(new NestedInteger(Integer.parseInt(num.toString())));
                        clearNum(num);
                    }
                    break;
                case ']':
                    if (num.length() != 0) {
                        stk.peek().add(new NestedInteger(Integer.parseInt(num.toString())));
                        clearNum(num);
                    }
                    NestedInteger ni = stk.pop();
                    if (!stk.isEmpty()) {
                        stk.peek().add(ni);
                    } else {
                        return ni;
                    }
                    break;
                default:
                    num.append(s.charAt(i));
                    break;
            }
        }
        return null;
    }


    public void clearNum(StringBuilder sb) {
        sb.delete(0,sb.length());
    }



    // recursive version
    /*
    int i = 1;
    int start = i;

    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') return new NestedInteger(Integer.valueOf(s));
        NestedInteger res = new NestedInteger();
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '[') {
                start = ++i;
                NestedInteger ni = deserialize(s);
                res.add(ni);
            }
            else if (c == ']' || c == ',') {
                String num = s.substring(start, i);
                if (!num.equals("")) {
                    int n = Integer.valueOf(num);
                    NestedInteger ni = new NestedInteger(n);
                    res.add(ni);
                }
                start = ++i;
                if (c == ']') break;
            }
            else
                i++;
        }
        return res;
    }
    */
}
