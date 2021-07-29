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

/**
@Leetcode - https://leetcode.com/problems/path-sum/
 */
class Solution {
    boolean found = false;
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return found;
        }
        helper(root, 0, targetSum);
        return found;
    }
    
    private void helper(TreeNode node, int sum, int targetSum) {
        if (node == null || found == true) {
            return;
        }
        sum += node.val;
        
        if (node.left == null && node.right == null) {
            if (sum == targetSum) {
                found = true;
                return;
            }
        }
        helper(node.left, sum, targetSum);
        helper(node.right, sum, targetSum);
    }
}
