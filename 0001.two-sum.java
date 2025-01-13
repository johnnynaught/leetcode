/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> map = new HashMap<>();

      for(int i = 0; i < nums.length; i++){
        int j = target - nums[i];
        if(map.containsKey(j)){
          return new int[]{i, map.get(j)};
        }
        map.put(nums[i], i);
      }
      return null;
    }
}
// @lc code=end

