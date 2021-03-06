/**
@Leetcode - https://leetcode.com/problems/find-largest-value-in-each-tree-row/
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        helper(root, 0, result);
        
        return result;
    }
    
    private void helper(TreeNode root, int level, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (result.size()  == level) {
            result.add(root.val);
        } else {
            result.set(level, Math.max(result.get(level), root.val));
        }
        helper(root.left, level+1, result);
        helper(root.right, level+1, result);
    }
}
