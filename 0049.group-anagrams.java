/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
          int[] counter = new int[26];
          for(int i = 0; i < s.length(); i++){
            counter[s.charAt(i) - 'a']++;
          }
          String key = Arrays.toString(counter);
          map.putIfAbsent(key, new ArrayList<>());
          map.get(key).add(s);
        }

        return new ArrayList(map.values());
    }
}
// @lc code=end

