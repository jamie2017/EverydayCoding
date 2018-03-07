package ByComs.Google.OA;

/**
 * Created by JMYE on 11/3/16.
 */
import java.util.HashSet;
import java.util.Stack;
public class ImageDirectory {
    private static int sum;
    private static  int numberOfimg;

    public static int solution(String S) {
        sum = 0;
        numberOfimg = 0;
        String[] ss = S.split("\n");
        helper(ss);
        return sum == 0 ? numberOfimg : sum;
    }

    public static void helper(String[] ss) {
        HashSet<String> set = new HashSet();
        StringBuilder b = new StringBuilder();
        Stack<Integer> st = new Stack();
        int index = 0;
        boolean[] visit = new boolean[ss.length];
        int num = 0;
        while (index < ss.length) {
            st.push(index++);
            while (!st.empty()) {
                int s = st.peek();
                if (!visit[s]) {
                    visit[s] = true;
                    if (!ss[s].contains(".")) {
                        num = num + 1 + ss[s].trim().length();
                        b.append('/');
                    }
                }
                b.append(ss[s].trim());
                if (check(ss[s]) && set.add(b.toString())) {
                    numberOfimg++;
                    sum = sum + num;
                }
                if (index < ss.length && isNextLev(ss[index], ss[s])) {
                    st.push(index++);
                } else {
                    int s1 = st.pop();
                    if (!ss[s1].contains(".")) {
                        b.delete(b.length() - ss[s1].trim().length() - 1, b.length());
                        num = num - 1 - ss[s1].trim().length();
                    }
                }
            }
        }
    }

    public static boolean isNextLev(String s1, String s) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                a = i;
                break;
            }
        }

        for (int j = 0; j < s1.length(); j++) {
            if (s1.charAt(j) != ' ') {
                b = j;
                break;
            }
        }
        return b - a == 1;
    }


    public static boolean check(String s) {
        String s2 = s.trim();
        int a = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == '.') {
                a = i;
                break;
            }
        }

        String s1 = s2.substring(a);
        return s1.equals(".jpeg") || s1.equals(".gif") || s1.equals(".png");
    }

    public static void main(String[] args) {
        String s = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif\n file3.gif\ndir3\n file4.png";
//        String s = "dir1\n file.png";
        System.out.println(s);
        System.out.println(solution(s)); // "/dir1/dir12/picture.jpeg" 24
//        System.out.println(solution(s)); // "/dir1/dir12" 11
//        System.out.println(lengthLongestPath_total(s)); // return 11 + 5 = 16, /dir1/dir12 + /dir2
    }
}
