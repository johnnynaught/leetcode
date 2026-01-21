/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int longest = 0;

        for(int num : set){
            int len = 1;
            int cur = num;
            if(!set.contains(cur-1)){
                len = 1;            
                while(set.contains(cur+1)){
                    len++;
                    cur++;
                }
            }
            longest = Math.max(longest, len);
        }
        return longest;
    }
}
// @lc code=end

