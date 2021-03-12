/**
    Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
    For example:
    Given binary tree [3,9,20,null,null,15,7],
           3
          / \
         9  20
           /  \
          15   7
    return its zigzag level order traversal as:
    [
    [3],
    [20,9],
    [15,7]
    ]
    
    @Leetcode - https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        zigzagLevelOrderRecursive(root, result, 0);
        
        return result;
    }
    
    private void zigzagLevelOrderRecursive(TreeNode node, List<List<Integer>> result, int level) {
        if (node == null) {
            return;
        }
        List <Integer> thisLevelResult;
        if (result.size() <= level) {
            thisLevelResult = new ArrayList<>();
            result.add(thisLevelResult);
        } else {
            thisLevelResult = result.get(level);
        }
        
        if (level % 2 == 0) {
            thisLevelResult.add(node.val);   
        } else {
            thisLevelResult.add(0, node.val);
        }
        zigzagLevelOrderRecursive(node.left, result, level+1);
        zigzagLevelOrderRecursive(node.right, result, level+1);
    }
}
