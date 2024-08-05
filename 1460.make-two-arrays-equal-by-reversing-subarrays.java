/*
 * @lc app=leetcode id=1460 lang=java
 *
 * [1460] Make Two Arrays Equal by Reversing Subarrays
 */

// @lc code=start
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);

        for(int i = 0; i < target.length; i++){
            if(target[i] != arr[i]) return false;
        }
        return true;
    }
}
// @lc code=end

