/*
 * @lc app=leetcode id=543 lang=java
 *
 * [543] Diameter of Binary Tree
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
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);  // Start calculating the diameter
        return diameter;
    }

    private int depth(TreeNode node) {
        // If the node is null, return 0 as the height of an empty tree
        if (node == null) return 0;

        // Recursively calculate the depth of the left and right subtrees
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        // Update the diameter (it can be the sum of the left and right depths)
        diameter = Math.max(diameter, leftDepth + rightDepth);

        // Return the height of the current node
        return Math.max(leftDepth, rightDepth) + 1;
    }
}

// @lc code=end

