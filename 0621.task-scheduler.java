/*
 * @lc app=leetcode id=621 lang=java
 *
 * [621] Task Scheduler
 */

// @lc code=start
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        int maxCount = 0;
        for(char task : tasks){
            arr[task - 'A']++;
            maxCount = Math.max(maxCount, arr[task - 'A']);
        } 

        // every loop include n+1 tasks, and there are maxCount-1 loops before the last loop
        int slots = (n+1) * (maxCount - 1);
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == maxCount) slots++;
        }

        return Math.max(tasks.length, slots);

    }
}
// @lc code=end

