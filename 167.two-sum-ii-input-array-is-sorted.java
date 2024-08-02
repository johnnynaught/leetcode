/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input Array Is Sorted
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length-1;
        while(i < j){
            if(numbers[i] + numbers[j] == target){
                return new int[]{i+1, j+1};
            }
            if(numbers[i] + numbers[j] < target){
                i++;
            }else{
                j--;
            }
        }
        return null;        
    }
}
// @lc code=end

