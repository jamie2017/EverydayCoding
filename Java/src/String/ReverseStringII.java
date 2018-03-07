package String;

/**
 * Created by JMYE on 3/17/17.
 */
public class ReverseStringII {
    public static String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        while (i < n) {
            int j = Math.min(i + k - 1, n - 1);
            swap(arr, i,j);
            i += 2 * k;
        }
        return String.valueOf(arr);
    }

    private static void swap(char[] arr, int l, int r) {
        while (l < r) {
            char tmp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = tmp;
        }
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s,k));
    }
}
