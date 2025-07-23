/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        int high = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > high) {
                high = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < high; j++) {
                if (arr[i]==j) {
                    continue;
                } else {
                    return j;
                }
            }
        }
    }
}
// @lc code=end

