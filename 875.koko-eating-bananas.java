/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 */

// @lc code=start
class Solution {
    public int calMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }
        return max;
    }

    public long calEatingTime(int[] piles, int k) {
        long totalTime = 0;
        for (int i = 0; i < piles.length; i++) {
            totalTime += (piles[i] + (k - 1L)) / k;
        }
        return totalTime;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = calMax(piles);
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long totalEatingTime = calEatingTime(piles, mid);
            if (totalEatingTime <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
// @lc code=end
