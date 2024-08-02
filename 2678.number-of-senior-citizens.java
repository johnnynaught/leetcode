/*
 * @lc app=leetcode id=2678 lang=java
 *
 * [2678] Number of Senior Citizens
 */

// @lc code=start
class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(String s : details){
            int age = Integer.valueOf(s.substring(11, 13));
            if(age > 60) count++;
        }
        return count;
    }
}
// @lc code=end

