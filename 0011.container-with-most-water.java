/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = -1;

        while(i < j){
            if(height[i] <= height[j]){
                int temp = (j - i) * height[i];
                max = Math.max(max, temp);
                i++;
            }
            if(height[i] > height[j]){
                int temp = (j - i) * height[j];
                max = Math.max(max, temp);
                j--;
            }
        }
        return max;
    }
}
// @lc code=end

