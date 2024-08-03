/*
 * @lc app=leetcode id=2134 lang=java
 *
 * [2134] Minimum Swaps to Group All 1's Together II
 */

// @lc code=start
class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int totalOnes = 0;
        for(int num : nums){
            if(num == 1) totalOnes++;
        }
        int left = 0;
        int onesInWindow = 0, onesInWindowMax = 0;
        for(int right = 0; right < 2*n-1; right++){
            if(nums[right % n] == 1){
                onesInWindow++;
            }
            if(right - left + 1 > totalOnes){
                onesInWindow -= nums[left % n];
                left++;
            }
            onesInWindowMax = Math.max(onesInWindow, onesInWindowMax);
        }
        return totalOnes - onesInWindowMax;        
    }
}
// @lc code=end

