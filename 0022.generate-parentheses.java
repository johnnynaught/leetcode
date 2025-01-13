/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n < 0){
            return res;
        }
        char[] arr = new char[2*n];
        DFS(res, arr, 0, 0, 0, n);
        return res;
    }

    // leftAdded：到目前为止 加了几个左括号
    // rightAdded：到目前为止 加了几个右括号
    // index：当前正在填写array里哪个位置
    private void DFS(List<String> res, char[] arr, int leftAdded, int rightAdded, int index, int n){
        if(index == arr.length){
            res.add(new String(arr));
            return;
        }

        if(leftAdded < n){
            arr[index] = '(';
            DFS(res, arr, leftAdded + 1, rightAdded, index+1, n);
        }

        if(leftAdded > rightAdded){
            arr[index] = ')';
            DFS(res, arr, leftAdded, rightAdded + 1, index+1, n);
        }
    }
}
// @lc code=end

