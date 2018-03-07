package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 2/24/17.
 */

//526. Beautiful Arrangement
public class BeautifulArrangement {
    public int countArrangement(int N) {
        int counter = 0;
        List<ArrayList<Integer>> pool = new ArrayList<>();
        pool.add(new ArrayList<>());
        while (!pool.isEmpty()) {
            System.out.println("In pool");
            ArrayList<Integer> a = pool.remove(pool.size() - 1);
            System.out.println(a);
            System.out.println("<><><>>>");
            if (a.size() == N) {
                counter ++;
            } else {
                for(int x = 1; x <= N; x++) {
                    if (a.indexOf(x) == -1) {
                        int i_th = a.size() + 1;
                        if (x % i_th == 0 || i_th % x == 0) {
                            a.add(x);
                            pool.add(new ArrayList(a));
                            a.remove(a.size() - 1);
                        }
                    }
                }
            }
        }
        return counter;

    }

    public int countArrangement2(int N) {
        return backtrack(new boolean[N], 0);
    }

    public int backtrack(boolean[] used, int curIndex) {
        if (curIndex == used.length) return 1;
        int sum = 0;
        for (int i=0;i<used.length;i++) {
            if (!used[i] && ((i+1) % (curIndex+1) == 0 || (curIndex + 1) % (i+1) == 0)) {
                used[i] = true;
                sum += backtrack(used, curIndex + 1);
                used[i] = false;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        BeautifulArrangement test = new BeautifulArrangement();
        int N = 3;
        System.out.println(test.countArrangement(N));
        System.out.println(test.countArrangement2(N));
    }
}
