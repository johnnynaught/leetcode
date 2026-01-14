/*
 * @lc app=leetcode id=508 lang=java
 *
 * [508] Most Frequent Subtree Sum
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {        
    private Map<Integer, Integer> map = new HashMap<>();
    private int highest = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        
        treeSum(root);

        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == highest){
                list.add(entry.getKey());
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private int treeSum(TreeNode root){
        if(root == null){
            return 0;
        }
        int rightTreeSum = treeSum(root.right);
        int leftTreeSum = treeSum(root.left);
        int curSum = rightTreeSum + leftTreeSum + root.val;

        map.put(curSum, map.getOrDefault(curSum, 0) +1);
        highest = Math.max(highest, map.get(curSum));
        return curSum;
    }
}
// @lc code=end

