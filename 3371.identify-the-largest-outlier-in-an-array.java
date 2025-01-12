/*
 * @lc app=leetcode id=3371 lang=java
 *
 * [3371] Identify the Largest Outlier in an Array
 */

// @lc code=start
class Solution {
    public int getLargestOutlier(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = Integer.MIN_VALUE;

        for(int num : nums){
            sum += num;
            map.put(num, map.getOrDefault(num, 0) +1);
        }

        for(int num : nums){
            int target = sum - 2*num;
            if(map.containsKey(target)){
                // If outlier == candidate, then we need at least 2 occurrences of that number.
                // Else, we need at least 1 occurrence.
                if(target != num || (target == num && map.get(target) > 1)){
                    res = Math.max(res, target);
                }
            }
        }
        return res;
    }
}
// @lc code=end

