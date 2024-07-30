/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
          map.put(num, map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for(int n : map.keySet()){
          pq.add(n);
          if(pq.size() > k){
            pq.poll();
          }
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++){
          res[i] = pq.poll();
        }
        return res;
    }
}
// @lc code=end

