/*
 * @lc app=leetcode id=3016 lang=java
 *
 * [3016] Minimum Number of Pushes to Type Word II
 */

// @lc code=start
class Solution {
    public int minimumPushes(String word) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c : word.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        maxHeap.addAll(map.values());

        int min = 0;
        int frequenceIndex= 0;

        while(!maxHeap.isEmpty()){
            int times = frequenceIndex / 8 + 1;
            min += times * maxHeap.poll();
            frequenceIndex++;
        }
        return min;
    }
}
// @lc code=end

