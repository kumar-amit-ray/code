/**
@Leetcode - https://leetcode.com/problems/binary-tree-vertical-order-traversal/

The solution is not accepted because - 
Input: root = [3,9,8,4,0,1,7,null,null,null,2,5]
We always get -[[4],[9,5],[3,0,1],[2, 8],[7]]
Expected - [[4],[9,5],[3,0,1],[8, 2],[7]]


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
    private int minLevel = Integer.MAX_VALUE;
    private int maxLevel = Integer.MAX_VALUE;
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if (root == null) {
            return result;
        }
        Map<Integer, List<Integer>> hmap = new HashMap();
        helper(root, 0, hmap);
        
        int i = minLevel;
        while (i <= maxLevel) {
            List<Integer> l = new ArrayList();
            l.addAll(hmap.get(i));
            result.add(l);
            i++;
        }
        return result;
    }
    
    private void helper(TreeNode root, int level, Map<Integer, List<Integer>> hmap) {
        if (root == null) {
            return;
        }
        if (hmap.containsKey(level)) {
            hmap.get(level).add(root.val);
        } else {
            List<Integer> l = new ArrayList();
            l.add(root.val);
            hmap.put(level, l);  
        }
        if (minLevel == Integer.MAX_VALUE) {
            minLevel = level;
            maxLevel = level;
        } else if (level < minLevel) {
            minLevel = level;
        } else if (level > maxLevel) {
            maxLevel = level;
        }
        
        helper(root.left, level-1, hmap);
        helper(root.right, level+1, hmap);
    }
}
