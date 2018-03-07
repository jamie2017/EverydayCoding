package String;

/**
 * Created by JMYE on 9/19/16.
 */
public class ReverseWordsinaStringII {
    // reverse whole string first
    // reverse word by word
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int r = 0;
        while (r < s.length) {
            int l = r;
            while (r < s.length && s[r] != ' ') {
                r++;
            }
            reverse(s, l, r - 1);
            r++;
        }
    }

    public void reverse(char[] s, int l, int r) {
        while (l < r) {
            char tmp = s[l];
            s[l++] = s[r];
            s[r--] = tmp;
        }
    }

//    557. Reverse Words in a String III

    public String reverseWords(String s) {
        char[] wordChar = s.toCharArray();
        int i = 0, j = 0;
        while (j < s.length()) {
            if (wordChar[j] == ' ') {
                swap(wordChar, i, j - 1);
                i = j + 1;
            }
            j ++;
        }
        swap(wordChar,i,j-1);
        return new String(wordChar);
    }

    private void swap(char[] words, int i, int j) {
        while (i < j) {
            char tmp = words[j];
            words[j--] = words[i];
            words[i++] = tmp;
        }
    }
}
