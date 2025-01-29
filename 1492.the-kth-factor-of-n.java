/*
 * @lc app=leetcode id=1492 lang=java
 *
 * [1492] The kth Factor of n
 */

// @lc code=start
class Solution {
    public int kthFactor(int n, int k) {
        int count = 0;
        for( int i = 1; i <= n; i++){
            if(n % i == 0){
                count++;
                if(count == k){
                    return i;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

