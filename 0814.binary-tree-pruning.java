/*
 * @lc app=leetcode id=814 lang=java
 *
 * [814] Binary Tree Pruning
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
    public TreeNode pruneTree(TreeNode root) {
        if(containsOne(root)){
            return root;
        }
        return null;
    }

    private boolean containsOne(TreeNode root){
        if(root == null){
            return false;
        }

        boolean leftSubtreeContainsOne = containsOne(root.left);
        boolean rightSubtreeContainsOne = containsOne(root.right);

        if(!leftSubtreeContainsOne) root.left = null;
        if(!rightSubtreeContainsOne) root.right = null;

        return leftSubtreeContainsOne || rightSubtreeContainsOne || root.val == 1;
    }
}
// @lc code=end

