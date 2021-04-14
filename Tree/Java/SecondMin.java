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
@Leetcode - https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
@Youtube - https://www.youtube.com/watch?v=8m_VaMHSCko
@Note - we had to use a boolean flag 'found' to handle a special case of node value = Integer.MAX_VALUE
 */
class Solution {
    int minV;
    int result;
    boolean found;
    
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        minV = root.val;
        result = Integer.MAX_VALUE;
        found = false;
        
        helper(root);
        return found ? result : -1;
    }
    
    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.val == minV) {
            helper(root.left);
            helper(root.right);
        } else if (root.val > minV && root.val <= result) {
            found = true;
            result = root.val;
        }
    }
}
