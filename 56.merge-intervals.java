/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        Deque<int[]> merged = new ArrayDeque<>();
        for(int[] interval : intervals){
            //[1,2] [3,4]
            if(merged.isEmpty() || merged.peekLast()[1] < interval[0]){
                merged.offer(interval);
            }else{
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
// @lc code=end

