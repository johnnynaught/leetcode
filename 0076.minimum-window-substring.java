/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // If the string `s` is empty, or `t` is empty, or `s` is shorter than `t`, return an empty string
        if(m == 0 || n == 0 || m < n) return "";

        // HashMap to keep a count of all the characters in string `t`
        Map<Character, Integer> map = new HashMap<>();

        // Populate the map with character counts from `t`
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int matched = 0; // Number of characters that match the desired count from `t`
        int l = 0; // Left pointer of the sliding window
        int minLen = s.length() + 1; // Initialize the minimum length of the substring to be larger than `s`
        int subStrIndex = 0; // Start index of the minimum window substring

        // Right pointer of the sliding window moves through the string `s`
        for(int r = 0; r < m; r++){
            char right = s.charAt(r);
            
            // If the character is part of `t`, decrease its count in the map
            if(map.containsKey(right)){
                map.put(right, map.get(right) - 1);
                
                // If the character count matches zero, increment the matched count
                if(map.get(right) == 0) matched++;
            }

            // When all characters are matched, try to shrink the window from the left
            while(matched == map.size()){
                // Update the minimum length and start index if the current window is smaller
                if(r - l + 1 < minLen){
                    minLen = r - l + 1;
                    subStrIndex = l;
                }

                // Character to be removed from the window
                char deleted = s.charAt(l);
                l++; // Move the left pointer to the right
                
                // If the removed character was part of `t`, update its count in the map
                if(map.containsKey(deleted)){
                    if(map.get(deleted) == 0) matched--; // If character count goes below zero, reduce matched
                    map.put(deleted, map.get(deleted) + 1);
                }
            }
        }
        
        // Return the minimum window substring, or an empty string if no valid window is found
        return minLen > s.length() ? "" : s.substring(subStrIndex, subStrIndex + minLen);
    }
}
// @lc code=end

