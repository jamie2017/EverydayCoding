package ByComs.Google;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by JMYE on 9/27/16.
 */
public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
//        Deque<Integer> stack = new ArrayDeque<>();
        // stack store the length for every path
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // "dummy" length
        int maxLen = 0;
        for(String s:input.split("\n")){
            System.out.println("s: " + s);
            int lev = s.lastIndexOf("\t")+1; // number of "\t"
            // if current level had no same level in stack, then lev + 1 == stack.size()
            while(lev + 1 < stack.size()) stack.pop(); // find parent, need to pop() to remove same level
            int len = stack.peek() + s.length() - lev + 1; // remove "/t", add"/"
            stack.push(len);
            // check if it is file
            if(s.contains(".")) maxLen = Math.max(maxLen, len - 1); // remove last "/"
        }
        return maxLen;
    }

    public int lengthLongestPath2(String input) {
        String[] paths = input.split("\n");
        int[] stack = new int[paths.length+1];
        int maxLen = 0;
        for(String s:paths){
            int lev = s.lastIndexOf("\t")+1, curLen = stack[lev+1] = stack[lev]+s.length()-lev+1;
            if(s.contains(".")) maxLen = Math.max(maxLen, curLen-1);
        }
        return maxLen;
    }


    public static void main (String[] args) {
        LongestAbsoluteFilePath test = new LongestAbsoluteFilePath();
        String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        test.lengthLongestPath(input);
    }
}
