/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int res [] = new int[n-k+1];
        Deque<Integer> q = new ArrayDeque<>();
        int l = 0, r = 0;

        while(r < n){
            // if element in queue is smaller, remove it
            while(!q.isEmpty() && nums[q.peekLast()] < nums[r]) {
                q.pollLast();
            }
            q.offer(r);

            // remove all elements not in the window
            if(l > q.peekFirst()) {
                q.pollFirst();
            }
            if(r + 1 >= k){
                res[l] = nums[q.peekFirst()];
                l++;
            }
            r++;
        }
        return res;
    }
}
// @lc code=end

