/*
 * @lc app=leetcode id=1768 lang=java
 *
 * [1768] Merge Strings Alternately
 */

// @lc code=start
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int i = 0;
        int j = 0;

        StringBuilder res = new StringBuilder();

        while(i < m || j < n){
            if(i < m){
                res.append(word1.charAt(i));
                i++;
            }
            if(j < n){
                res.append(word2.charAt(j));
                j++;
            }
        }

        return res.toString();
    }
}
// @lc code=end

