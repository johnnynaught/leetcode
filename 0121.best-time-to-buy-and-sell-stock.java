/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;

        for(int p : prices){
            min = Math.min(min, p);
            maxProfit = Math.max(maxProfit, p - min);
        }
        return maxProfit;
    }
}
// @lc code=end

