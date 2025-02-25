/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int res = 0;

        for(int r = 0; r < nr; r++){
            for(int c = 0; c < nc ; c++){
                if(grid[r][c] == '1'){
                    res++;
                    dfs(grid, r, c);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int r, int c){
        int nr = grid.length;
        int nc = grid[0].length;

        if(r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0'){
            return;
        }

        grid[r][c] = '0';

        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
    }
}
// @lc code=end

