package Math;

/**
 * Created by JMYE on 8/27/16.
 */
public class CountPrimes {
    public int countPrimes(int n) { //O(n log log n)
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        CountPrimes test = new CountPrimes();
        System.out.println(test.countPrimes(10));
    }
}
