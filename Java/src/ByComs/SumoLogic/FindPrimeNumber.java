package ByComs.SumoLogic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JMYE on 7/5/17.
 */
public class FindPrimeNumber {
    public List<Integer> findPrime(int n) { // O(n^2)
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        primes.add(3);
        boolean notPrime;
        for(int i = 4; i < n; i++) {
            notPrime = false;
            for (Integer p : primes) {
                if (i % p == 0) {
                    notPrime = true;
                    break;
                }
            }
            if (!notPrime) {
                primes.add(i);
            }
        }
        return primes;
    }

    public List<Integer> findPrimeOpt(int n) {//O(n log log n)
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindPrimeNumber  test = new FindPrimeNumber();
        List<Integer> primes = test.findPrime(10);
        System.out.println(primes);
        System.out.println(primes.size());
        System.out.println(test.findPrimeOpt(10));
    }

}
