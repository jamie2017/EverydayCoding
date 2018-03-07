package Heap;

import java.util.PriorityQueue;

/**
 * Created by JMYE on 10/6/16.
 */
public class nthSuperUglyNumberI {
    // Similar to ugly number II solution
    public int nthSuperUglyNumberII(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];

        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            //find next
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++)
                ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);

            //slip duplicate
            for (int j = 0; j < primes.length; j++) {
                while (primes[j] * ugly[idx[j]] <= ugly[i]) idx[j]++;
            }
        }

        return ugly[n - 1];
    }

    public int nthSuperUglyNumberHeap(int n, int[] primes) {
        int[] ugly = new int[n];

        PriorityQueue<Num> pq = new PriorityQueue<>();
        for (int i = 0; i < primes.length; i++) pq.add(new Num(primes[i], 1, primes[i]));
        ugly[0] = 1;

        for (int i = 1; i < n; i++) {
            ugly[i] = pq.peek().val;
            while (pq.peek().val == ugly[i]) {
                Num nxt = pq.poll();
                pq.add(new Num(nxt.p * ugly[nxt.idx], nxt.idx + 1, nxt.p));
            }
        }

        return ugly[n - 1];
    }

    private class Num implements Comparable<Num> {
        int val;
        int idx;
        int p;

        public Num(int val, int idx, int p) {
            this.val = val;
            this.idx = idx;
            this.p = p;
        }

        @Override
        public int compareTo(Num that) {
            return this.val - that.val;
        }
    }
}
