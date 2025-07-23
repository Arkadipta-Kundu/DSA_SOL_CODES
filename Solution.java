/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 */

// @lc code=start
public class Solution {
    public int countPrimes(int n) {
        if (n <= 2)
            return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true); // Assume all numbers are prime initially
        isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // Mark all multiples of i as not prime
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Count the number of primes
        int count = 0;
        for (boolean prime : isPrime) {
            if (prime)
                count++;
        }

        return count;
    }
}

// @lc code=end

