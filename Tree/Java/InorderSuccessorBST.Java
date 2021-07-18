/**
@Leetcode - https://leetcode.com/problems/inorder-successor-in-bst/

 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        
        // if the node has right subtree, find the inoder successer is the left most child of the right subtree.
        if (p.right != null) {
            TreeNode temp = p.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }
        
        // no right subtree, so parent is the inorder successor. 
        TreeNode temp = root;
        TreeNode parent = null;
        while (temp != null) {
            if (temp.val > p.val) {
                parent = temp;
                temp = temp.left;
            } else if (temp.val < p.val) {
                temp = temp.right;
            } else {
                break;
            }
        }
        return parent;
    }
}
