/*
 * @lc app=leetcode id=853 lang=java
 *
 * [853] Car Fleet
 */

// @lc code=start
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] pairs = new double[n][2];
        
        // Create pairs of position and speed
        for (int i = 0; i < n; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }
        
        // Sort pairs by position in ascending order
        Arrays.sort(pairs, (a, b) -> Double.compare(a[0], b[0]));
        
        int fleet = 0;
        double maxTime = 0;
        
        // Traverse from the end to the beginning
        for (int i = n - 1; i >= 0; i--) {
            double time = (target - pairs[i][0]) / pairs[i][1];
            if (time > maxTime) {
                fleet++;
                maxTime = time;
            }
        }
        return fleet;
    }
}
// @lc code=end

