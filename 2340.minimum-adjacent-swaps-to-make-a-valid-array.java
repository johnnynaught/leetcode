/*
 * @lc app=leetcode id=2340 lang=java
 *
 * [2340] Minimum Adjacent Swaps to Make a Valid Array
 */

// @lc code=start
class Solution {
    public int minimumSwaps(int[] nums) {
        int n = nums.length;
        int maxIndex = n - 1;
        int minIndex = 0;

        for(int i = 1; i < n; i++){
            if(nums[maxIndex] < nums[n-1-i]){
                maxIndex = n - 1 - i;
            }
            if(nums[minIndex] > nums[i]){
                minIndex = i;
            }
        }

        if(minIndex > maxIndex){
            return (n-1-maxIndex) + minIndex - 1;
        }else{
            return (n-1-maxIndex) + minIndex;
        }
    }
}
// @lc code=end

