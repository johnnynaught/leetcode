/*
 * @lc app=leetcode id=2053 lang=java
 *
 * [2053] Kth Distinct String in an Array
 */

// @lc code=start
class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String s : arr){
            map.put(s, map.getOrDefault(s, 0)+1);
        }

        for(String s : arr){
            if(map.get(s) == 1) k--;
            if(k == 0){
                return s;
            }
        }
        
        return "";
    }
}
// @lc code=end

