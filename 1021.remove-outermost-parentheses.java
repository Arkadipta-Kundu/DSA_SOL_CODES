/*
 * @lc app=leetcode id=1021 lang=java
 *
 * [1021] Remove Outermost Parentheses
 */

// @lc code=start
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length() - 1;
        int parentheses = 0;
        for (int i = 0; i <= n; i++) {
            if (s.charAt(i) == '(') {
                if (parentheses > 0) {
                    sb.append('(');
                }
                parentheses++;
            } else {
                if (parentheses > 1) {
                    sb.append(')');
                }
                parentheses--;
            }
        }
        return sb.toString();
    }
}
// @lc code=end
