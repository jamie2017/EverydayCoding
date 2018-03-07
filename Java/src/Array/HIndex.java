package Array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by JMYE on 6/30/17.
 */
public class HIndex {
    public int hIndex(int[] citations) {

        // solution 1 O(nlgn)
        // Arrays.sort(citations);
        // int i = 0;
        // while (i < citations.length && citations[citations.length - 1 - i] > i) {
        //     i++;
        // }
        // return i;

        // O(n)

        int n = citations.length;
        int[] papers = new int[n + 1];
        // counting papers for each citation number
        for (int c : citations)
            papers[Math.min(n, c)]++;
        // finding the h-index
        System.out.println(Arrays.toString(papers));
        int h = n;
        for (int s = papers[n]; h > s; s += papers[h]){
            System.out.println("s=" + s + " , h=" + h);
            h--;
        }
        return h;
    }
    public static void main(String[] args) {
        HIndex test = new HIndex();
        int[] citations1 = {1,3,2,3,100};
        System.out.println(test.hIndex(citations1));
        int[] citations2 = {5,5,5,5,5};
        System.out.println(test.hIndex(citations2));
        int [] citations3 = {4,4,4,4,4};
        System.out.println(test.hIndex(citations3));
    }
}
