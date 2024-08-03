/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        int leftH = height[left];
        int rightH = height[right];

        while(left < right){
            leftH = Math.max(leftH, height[left]);
            rightH = Math.max(rightH, height[right]);

            if(leftH < rightH){
                max += leftH - height[left];
                left++;
            }else{
                max += rightH - height[right];
                right--;
            }
        }
        return max;        
    }
}
// @lc code=end

