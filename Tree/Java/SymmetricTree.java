/**
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3

 @Leetcode - https://leetcode.com/problems/symmetric-tree/
 */
 
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode l, TreeNode r) {
        if (l != null && r != null) {
            if (!isSymmetricLevel(l, r)) {return false;}
            if (l.left != null && !helper(l.left, r.right)) {return false;}
            if (l.right != null && !helper(l.right, r.left)) {return false;}
        
            return true;
        } else if (l == null && r == null) {
            return true;
        } 
        return false;
    }
    
    private boolean isSymmetricLevel(TreeNode l, TreeNode r) {
            if (l.val != r.val) {return false;}
            if (l.left != null && r.right == null) {return false;}
            if (l.left == null && r.right != null) {return false;}
            if (l.right != null && r.left == null) {return false;}
            if (l.right == null && r.left != null) {return false;}
            return true;
    }
} 
