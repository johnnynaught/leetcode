/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 */

// @lc code=start
class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int res = 0;
        int max = 0;
        int l = 0;

        for(int r = 0; r < s.length(); r++){
            arr[s.charAt(r) - 'A']++;
            max = Math.max(max, arr[s.charAt(r) - 'A']);

            if(r - l + 1 - max > k){
                arr[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(r-l+1, res);
        }
        return res;
    }
}
// @lc code=end

