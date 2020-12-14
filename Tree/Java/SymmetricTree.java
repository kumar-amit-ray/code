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
        if (root == null || (root.left == null && root.right == null))  {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        return isSymmetricSubtreeRecursive(root.left, root.right);
    }
    
    private boolean isSymmetricSubtreeRecursive(TreeNode lst, TreeNode rst) {
        if (lst.val != rst.val) {return false;}
        if (lst.right != null && rst.left == null) {return false;}
        if (lst.right == null && rst.left != null) {return false;}
        if (lst.left == null && rst.right != null) {return false;}
        if (lst.left != null && rst.right == null) {return false;}
                
        if (lst.left != null) {
            boolean isSubTreeSymmetric1 = isSymmetricSubtreeRecursive(lst.left, rst.right);
            if (isSubTreeSymmetric1 == false) {
                return false;
            }
        }
        if (lst.right != null) {
            boolean isSubTreeSymmetric2 = isSymmetricSubtreeRecursive(lst.right, rst.left);
            if (isSubTreeSymmetric2 == false) {
                return false;
            }
        }
        return true;
    }
}
