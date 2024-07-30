/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
      int n = nums.length;
      int[] L = new int[n];
      int[] R = new int[n];
      int[] res = new int[n];

      L[0] = 1;
      R[n-1] = 1;

      for(int i = 1; i < n; i++){
        L[i] = L[i-1] * nums[i-1];
      }
      for(int i = n-1; i > 0; i--){
        R[i-1] = R[i] * nums[i];
      }

      for(int i = 0; i < n; i++){
        res[i] = L[i] * R[i];
      }

      return res;
    }
}
// @lc code=end

