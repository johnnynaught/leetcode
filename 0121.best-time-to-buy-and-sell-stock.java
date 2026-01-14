/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int p : prices){
            min = Math.min(p, min);
            maxProfit = Math.max(p - min, maxProfit);
        }

        return maxProfit;
    }
}
// @lc code=end

