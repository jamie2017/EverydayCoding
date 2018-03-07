package DP;

/**
 * Created by JMYE on 11/12/16.
 */
public class SentenceScreenFitting {

    /*
    1. String s = String.join(" ", sentence) + " " ;. This line gives us a formatted sentence to be put to our screen.

    2. start is the counter for how many valid characters from s have been put to our screen.

    3. if (s.charAt(start % l) == ' ') is the situation that we don't need an extra space for current row.
       The current row could be successfully fitted. So that we need to increase our counter by using start++.
    4. The else is the situation, which the next word can't fit to current row.
       So that we need to remove extra characters from next word.
    5. start / s.length() is (# of valid characters) / our formatted sentence.


    Given a rows x cols screen and a sentence represented by a list of words, find how many times the given sentence can be fitted on the screen.
     */


    public int wordsTyping_DP2loops(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0, l = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % l) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start-1) % l) != ' ') {
                    start--;
                }
            }
        }

        return start / s.length();
    }

    public static int wordsTypingDP(String[] sentence, int rows, int cols){ // optimized to O(m + n)
        String s = String.join(" ", sentence) + " ";
        System.out.println(">>" + s + "<<");
        int len = s.length(), count = 0;
        int[] map = new int[len];
        for (int i = 1; i < len; ++i) {
            map[i] = s.charAt(i) == ' ' ? 1 : map[i - 1] - 1;
        }
        System.out.println();
        for (int i = 0; i < rows; ++i) {
            count += cols;
            count += map[count % len];
        }
        return count / len;
    }

    public static int wordsTyping(String[] sentence, int rows, int cols) { // brute force
        if (sentence == null || sentence.length == 0) return 0;
        int cnt = 0;
        int k = 0;
        int remaining = cols;
        while(rows > 0) {
            if (k == sentence.length) {
                k = 0;
                cnt++;
            }
            if (sentence[k].length() > cols) return 0;

            if (k < sentence.length ) {
                if (remaining != cols && remaining < sentence[k].length() + 1) {
                    rows--;
                    remaining = cols;
                } else if ((remaining == cols && remaining > sentence[k].length() || (remaining > sentence[k].length() + 1))){
                    if (remaining == cols) {
                        remaining -= sentence[k].length();
                    } else {
                        remaining -= sentence[k].length() + 1;
                    }
                    k++;
                } else {
                    k++;
                    remaining = cols;
                    rows--;
                    if (rows == 0 && k == sentence.length) {
                        cnt++;
                    }
                }
            }

        }
        return cnt;
    }



    public static void main(String[] args) {
//        String[] sent = {"f","p","a"};
//        int rows = 8, cols = 7;
        String[] sent = {"I", "had", "apple", "pie"};
        int rows = 4, cols = 5;

//        String[] sent = {"a","b","c"};
//        int rows = 3, cols = 1;

//        String[] sent = {"hello","world"};
//        int rows = 2, cols = 8;
//        String[] sent = {"a","bc"};
//        int rows = 20000, cols = 20000;
        System.out.println(wordsTypingDP(sent,rows,cols));
//        System.out.println(wordsTyping(sent,rows,cols));

    }
}
