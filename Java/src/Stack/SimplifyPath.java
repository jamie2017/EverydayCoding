package Stack;

import java.util.*;

/**
 * Created by JMYE on 9/30/16.
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        boolean isAbsPath = path.charAt(0) == '/';
        Deque<String> stk = new LinkedList<>();
        for (String dir: path.split("/")) {
            if (dir.equals("..") && !stk.isEmpty()) {
                if (!stk.peek().equals("..")) {
                    stk.pop();
                } else if (!isAbsPath) {
                    stk.push(dir);
                }
            }  else if (!dir.equals(".") && !dir.equals("")) {
                stk.push(dir);
            }
        }
        String ans = "";
        if (path.charAt(0) == '/') {
            while (!stk.isEmpty() && stk.getLast().equals("..")) {
                stk.pollLast();
            }
        }
        while(!stk.isEmpty()) {
            ans = "/" + stk.pop() + ans;
        }
        if (!ans.isEmpty() && !isAbsPath ) {
            ans = ans.substring(1);
        }
        return ans.isEmpty() ? "./" : ans ;
    }
    public static void main (String[] args) {
        SimplifyPath test = new SimplifyPath();

        String path1 = "../var/../lib"; // ../lib
        String path2 = "var/.."; // ./
        String path3 = "./var/.."; // ./
        String path4 = "../var/../../lib"; //../../lib
        String path5 = "../var/../lib"; //../lib
        String path6 = "/var/../../lib";// /lib
        String path7 = "/var/local/.././lib/./run/";///var/lib/run/


        System.out.println(test.simplifyPath(path1));
        System.out.println(test.simplifyPath(path2));
        System.out.println(test.simplifyPath(path3));
        System.out.println(test.simplifyPath(path4));
        System.out.println(test.simplifyPath(path5));
        System.out.println(test.simplifyPath(path6));
        System.out.println(test.simplifyPath(path7));


    }
}
