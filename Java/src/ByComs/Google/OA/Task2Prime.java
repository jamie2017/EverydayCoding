package ByComs.Google.OA;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by JMYE on 11/6/16.
 */
public class Task2Prime {
    // 2.1, 2.2, 2.4
    // Use the space prefix to represent the level (depth) of the file
    public static int getFileLevel(String str)
    {
        int idx = 0;
        while (idx < str.length())
        {
            if (str.charAt(idx) != ' ')
            {
                break;
            }
            idx++;
        }
        return idx;
    }

    public static int lengthLongestPath2_1(String input) {
        Stack<Integer> stack = new Stack<>(); // stack store the length of path
        int maxLen = 0, level = 0, prevLen = 0, curLen = 0, dirLen = 0;// 2.1

        int slashLen = 1;
        for (String s : input.split("\n")) {
            level = getFileLevel(s);
            while (level < stack.size())
            {
                stack.pop();
            }
            prevLen = stack.empty() ? 0 : stack.peek();
            // previous directoy length + length of "/" + current directory length
            curLen = prevLen + slashLen + s.trim().length();  // 2.1, 2.2
//            stack.push(curLen);
            if (s.contains(".jpeg") || s.contains(".gif") || s.contains(".png"))
            {
                dirLen = curLen - s.trim().length() - slashLen; // 2.1
                maxLen = Math.max(maxLen, dirLen); // 2.1

            } else if (!s.contains(".")) {
                stack.push(curLen);
            }
        }
        return maxLen;
    }

    // 2.2

    public static int lengthLongestPath2_2(String input) {
        Stack<Integer> stack = new Stack<>(); // stack store the length of path
        int maxLen = 0, level = 0, prevLen = 0, curLen = 0; //2.2
        int slashLen = 1;
        for (String s : input.split("\n")) {
            level = getFileLevel(s);
            while (level < stack.size())
            {
                stack.pop();
            }
            prevLen = stack.empty() ? 0 : stack.peek();
            // previous directoy length + length of "/" + current directory length
            curLen = prevLen + slashLen + s.trim().length();  // 2.1, 2.2
//            stack.push(curLen);
            if (s.contains(".jpeg") || s.contains(".gif") || s.contains(".png"))
            {
                maxLen = Math.max(maxLen, curLen); // 2.2
            } else if (!s.contains(".")) {
                stack.push(curLen);
            }
        }
        return maxLen;
    }



    // 2.3

    public static int totalPathSum2_3(String input) {

        Set<String> checkUnique = new HashSet<>();
        Stack<String> pathStrStack = new Stack<>();
        Stack<Integer> lenStack = new Stack<>(); // stack store the length of path
        int totalLen = 0, level, curLen, dirLen; //2.4
        String dirStr;

        for (String s : input.split("\n")) {
            level = getFileLevel(s);
//            System.out.println("level " + level);
            while (level < lenStack.size())
            {
                lenStack.pop();
                pathStrStack.pop();
            }

            curLen =  1 + s.trim().length();
            dirStr = "/" + s.trim();
            if (!lenStack.isEmpty())
            {
                curLen = lenStack.peek() + curLen;
                dirStr = pathStrStack.peek() + dirStr;
            }

            if (s.contains(".jpeg") || s.contains(".gif") || s.contains(".png"))
            {
                String imgFilePath = pathStrStack.peek();
                System.out.println(imgFilePath);
                if(!checkUnique.contains(imgFilePath))
                {
                    dirLen = curLen - s.trim().length() - 1;
                    totalLen += dirLen;
                    checkUnique.add(imgFilePath);
                }
            } else if (!s.contains(".")) {
                lenStack.push(curLen);
                pathStrStack.push(dirStr);
            }
        }
        return totalLen;
    }

    public static int totalPathSum2_3s(String input) {
        Set<String> checkUnique = new HashSet<>();
        Stack<Integer> lenStack = new Stack<>(); // stack store the length of path
        StringBuilder sb = new StringBuilder();
        int totalLen = 0, level, curLen, dirLen, idx; //2.4

        for (String s : input.split("\n")) {
            level = getFileLevel(s);
            while (level < lenStack.size())
            {
                lenStack.pop();
            }

            curLen =  1 + s.trim().length();
            if (!lenStack.isEmpty())
            {
                curLen = lenStack.peek() + curLen;
                sb.delete(lenStack.peek(), sb.length());
            } else {
                sb.setLength(0);
            }

            System.out.println(sb.toString());

            if (s.contains(".jpeg") || s.contains(".gif") || s.contains(".png"))
            {
                String imgFilePath = sb.toString();
                if(!checkUnique.contains(imgFilePath))
                {
                    dirLen = curLen - s.trim().length() - 1;
                    totalLen += dirLen;
                    checkUnique.add(imgFilePath);
                }
            }
            else
            {
                lenStack.push(curLen);
                sb.append("/" + s.trim());
            }
        }
        return totalLen;
    }



    // 2.4
    public static int totalPathSum2_4(String input) {
        Stack<Integer> stack = new Stack<>(); // stack store the length of path
        int totalLen = 0, level = 0, prevLen = 0, curLen = 0;
        for (String s : input.split("\n")) {
            level = getFileLevel(s);
            while (level < stack.size())
            {
                stack.pop();
            }
            prevLen = stack.empty() ? 0 : stack.peek();
            // previous directoy length + length of "/" + current directory length
            curLen = prevLen + 1 + s.trim().length();
//            stack.push(curLen);
            if (s.contains(".jpeg") || s.contains(".gif") || s.contains(".png"))
            {
                totalLen += curLen;
            } else if (!s.contains(".")) {
                stack.push(curLen);
            }
        }
        return totalLen;
    }



    public static void main(String[] args) {
        String s = "dir1\n imagedddddddddddddd.txt\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif";
//        s = s + "\n file4.jpeg";
//          String s = "dir\n    file.gif";
//        String s = "dir1\n ciciismywifeandilovehersomuch.jpeg\n ss.gif\n dir11\n  dir22\n    dir33\n     a.gif";
        System.out.println(s);
//        String image = "/dir1/ciciismywifeandilovehersomuch.jpeg";
//        System.out.println("/dir1/ciciismywifeandilovehersomuch.jpeg " + image.length());
//        String dir = "/dir1/dir11/dir22/dir33/a.gif";
//        System.out.println("/dir1/dir11/dir22/dir33/a.gif " + dir.length());
//        System.out.println();
        System.out.println("lengthLongestPath2_1" +" : "+lengthLongestPath2_1(s));

        System.out.println("lengthLongestPath2_2" +" : "+lengthLongestPath2_2(s));
//        System.out.println();
        System.out.println("totalPathSum2_3s" +" : "+totalPathSum2_3s(s));
        System.out.println("totalPathSum2_3" +" : "+totalPathSum2_3(s));
//        int totalDirwithImage = "/dir1".length() + "/dir1/dir11/dir22/dir33".length();
//        System.out.println( "validation " + totalDirwithImage);
//        System.out.println();
        System.out.println("totalPathSum2_4" +" : "+totalPathSum2_4(s));
//
//
    }
}
