package TwoPointer;

/**
 * Created by JMYE on 9/4/16.
 */

//public class NBCompare {
//    public int cmp(String a, String b);
//}
 /*
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
 */
public class Nuts_Bolts { // MARK!!!
//    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBCompare compare) {
//        if (nuts == null || bolts == null) return;
//        if (nuts.length != bolts.length) return;
//
////        qsort(nuts,bolts,compare,0,nuts.length - 1);
//    }
//    private void qsort(String[] nuts, String[] bolts, NBCompare compare, int l, int u) {
//        if (l >= u) return;
//        int part_inx = partition(nuts, bolts[l], compare, l, u);
//        partition(bolts, nuts[part_inx], compare, l, u);
//        qsort(nuts, bolts, compare, l, part_inx - 1);
//        qsort(nuts, bolts, compare, part_inx + 1, u);
//    }
//
//    private  int partition(String[] str, String pivot, NBCompare compare, int l, int u) {
//        for (int i = l; i <= u; i++) {
//            if (compare.cmp(str[i], pivot) == 0 ||
//                    compare.cmp(pivot, str[i]) == 0) {
//                swap(str, i, l);
//                break;
//            }
//        }
//        String now = str[l];
//        int left = l;
//        int right = u;
//        while (left < right) {
//            while (left < right &&
//                    (compare.cmp(str[right],pivot) == -1 ||
//                    compare.cmp(pivot, str[right]) == 1)) {
//                right --;
//            }
//            str[left] = str[right];
//            while (left < right &&
//                    (compare.cmp(str[left], pivot) == 1 ||
//                    compare.cmp(pivot, str[left]) == -1)) {
//                left ++;
//            }
//            str[right] = str[left];
//        }
//        str[left] = now;
//
//        return left;
//    }
    private void swap (String[] str, int l, int r) {
        String temp = str[l];
        str[l] = str[r];
        str[r] = temp;
    }
}







