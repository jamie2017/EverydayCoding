package ByComs.Google.OA;

import java.util.Stack;

/**
 * Created by JMYE on 11/1/16.
 */
public class Task2 {

  // 2.1
    public static int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>(); // stack store the length of path
        stack.push(0); // length of "/"
        int maxLen = 0;
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf(" ") + 1;
            while (level + 1 < stack.size()) stack.pop();
            int tmpLen = stack.peek() + s.length() - level + 1;
            stack.push(tmpLen);
            if (s.contains(".jpeg") || s.contains(".gif") || s.contains(".png")) maxLen = Math.max(maxLen, tmpLen - s.length() + 1);
        }
        return maxLen;

    }

//  2.2

    public static int lengthLongestPathWithFileName(String input) {
        Stack<Integer> stack = new Stack<>(); // stack store the length of path
        stack.push(0); // length of "/"
        int maxLen = 0;
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf(" ") + 1;
            while (level + 1 < stack.size()) stack.pop();
            int tmpLen = stack.peek() + s.length() - level + 1;
            stack.push(tmpLen);
            if (s.contains(".jpeg") || s.contains(".gif") || s.contains(".png")) maxLen = Math.max(maxLen, tmpLen);
        }
        return maxLen;

    }

    // 2.3
    public static int totalPathSum(String input) {
        String[] arr = input.split("\n");
        int totalLen = 0, level = 0;
        for(int i = arr.length - 1;i >= 0;i--){
            String line = arr[i];
            if (line.contains(".jpeg")|| line.contains((".gif")) || line.contains(".png")) {
                level = line.length() - line.trim().length();

            }
            if(level > line.length() - line.trim().length()){
                totalLen += line.trim().length() + 1; // 1 for "/"
                totalLen %= 1000000007;
                level --;

            }
        }
        return totalLen % 1000000007;
    }


    //2.4
    public static int totalPathSumWithName3(String input) { // bettwe one
        Stack<Integer> stack = new Stack<>(); // stack store the length of path
        stack.push(0); // length of "/"
        int totalLen = 0;
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf(" ") + 1;
            while (level + 1 < stack.size()) stack.pop();
            int tmpLen = stack.peek() + s.length() - level + 1;
            stack.push(tmpLen);
            if (s.contains(".jpeg") || s.contains(".gif") || s.contains(".png")) totalLen += tmpLen % 1000000007 ;
        }
        return totalLen;

    }

//    public static int totalPathSumWithName2(String input) {
//
//        String[] arr = input.split("\n");
//        int totalLen = 0, level = 0;
//        int imageLen = 0;
//        for(int i = arr.length - 1;i >= 0;i--){
//            String line = arr[i];
//
//            if(line.contains(".jpeg") || line.contains(".gif") || line.contains(".png")){
//                level = line.length() - line.trim().length();
//                imageLen += line.trim().length() + 1;
//            }
//            if(!line.contains(".") && level > line.length() - line.trim().length()){
//                totalLen += line.trim().length() + 1; // 1 for "/"
//                totalLen += imageLen;
//                totalLen %= 1000000007;
//                level --;
//                imageLen = 0;
//
//            }
//        }
//        return totalLen % 1000000007;
//    }




    public static void main(String[] args) {
        String s = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif";
        s = s + "\n file4.jpeg";
        System.out.println(s);

        System.out.println(2.1 + " " + lengthLongestPath(s)); // "/dir1/dir12" 11
        System.out.println(2.2 + " " + lengthLongestPathWithFileName(s)); // "/dir1/dir12/picture.jpeg" 24
        System.out.println(2.3 + " " + totalPathSum(s)); // return 11 + 5 = 16, /dir1/dir12 + /dir2
        System.out.println(2.4 + " " + totalPathSumWithName3(s));//return 24 + 15 = 39, /dir1/dir12/picture.jpeg + /dir2/file2.gif
    }

}
