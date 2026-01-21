/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> boxes = new HashMap<>();

        for(int i = 0; i < n; i++){
            rows.put(i, new HashSet<>());
            cols.put(i, new HashSet<>());
            boxes.put(i, new HashSet<>());
        }

        for(int i = 0; i < n; i++){
          for(int j = 0; j < n; j++){
            char c = board[i][j];
            if(c == '.') continue;

            if(rows.get(i).contains(c) || cols.get(j).contains(c) || boxes.get(i/3*3 + j/3).contains(c)){
              return false;
            }
            rows.get(i).add(c);
            cols.get(j).add(c);
            boxes.get(i/3*3 + j/3).add(c);
          }
        }
        
        return true;
    }
}
// @lc code=end

