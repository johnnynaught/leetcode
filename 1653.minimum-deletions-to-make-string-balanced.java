/*
 * @lc app=leetcode id=1653 lang=java
 *
 * [1653] Minimum Deletions to Make String Balanced
 */

// @lc code=start
class Solution {
    public int minimumDeletions(String s) {
        int len = s.length();
        int min = 0;
        int bcount = 0;

        for(int i = 0; i < len; i ++){
            if(s.charAt(i) == 'b'){
                bcount++;
            }else{
                min = Math.min(min+1, bcount);
            }
        }
        return min;
    }
}
// @lc code=end

