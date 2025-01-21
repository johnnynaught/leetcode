/*
 * @lc app=leetcode id=767 lang=java
 *
 * [767] Reorganize String
 */

// @lc code=start
class Solution {
    public String reorganizeString(String s) {
        if(s == null || s.length() == 0) return "";

        int[] freq = new int[26];

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        int highest = 0;
        int letterIndex = 0;

        for(int i = 0; i < freq.length; i++){
            if(freq[i] > highest){
                highest = freq[i];
                letterIndex = i;
            }
        }

        if(highest > (s.length()+1)/2) return "";

        char[] res = new char[s.length()];
        int index = 0;

        while(freq[letterIndex] > 0){
            res[index] = (char)(letterIndex + 'a');
            index += 2;
            freq[letterIndex]--;
        }

        for(int i = 0; i < freq.length; i++){
            while(freq[i] > 0){
                if(index >= s.length()){
                    index = 1;
                }
                res[index] = (char)(i + 'a');
                index += 2;
                freq[i]--;
            }
        }

        return new String(res);
    }
}
// @lc code=end

