/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] s1arr = new int[26];
        int[] s2arr = new int[26];

        for(int i = 0; i < s1.length(); i++){
            s1arr[s1.charAt(i)-'a']++;
            s2arr[s2.charAt(i)-'a']++;
        }

        for(int i = 0; i < s2.length() - s1.length(); i++){
            if(match(s1arr, s2arr)) return true;
            // move left pointer 
            s2arr[s2.charAt(i)-'a']--;
            // move right pointer
            s2arr[s2.charAt(i + s1.length()) - 'a']++;
        }
        return match(s1arr, s2arr);
    }

    private boolean match(int[] arr1, int[] arr2){
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

