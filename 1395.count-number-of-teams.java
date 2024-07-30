/*
 * @lc app=leetcode id=1395 lang=java
 *
 * [1395] Count Number of Teams
 */

// @lc code=start
class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int res = 0;

        for(int i = 1; i < n-1; i++){        
            int leftSmaller = 0;
            int rightLarger = 0;
            int leftLarger = 0;
            int rightSmaller = 0;
            
            for(int j = 0; j < i; j++){
                if(rating[j] < rating[i]) leftSmaller++;
                if(rating[j] > rating[i]) leftLarger++;
            }
            for(int k = i+1; k < n; k++){
                if(rating[k] < rating[i]) rightSmaller++;
                if(rating[k] > rating[i]) rightLarger++;
            }

            res += leftSmaller * rightLarger;
            res += leftLarger * rightSmaller;
        }

        return res;
    }
}
// @lc code=end

