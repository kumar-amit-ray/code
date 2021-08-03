/**
@Leetcode - https://leetcode.com/problems/insert-into-a-binary-search-tree/
@Leetcode - https://leetcode.com/problems/delete-node-in-a-bst/

 */

class Solution {
  public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val, null, null);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
  
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode insucc = findInsucc(root);
            root.val = insucc.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
    
    private TreeNode findInsucc(TreeNode node) {
        TreeNode temp = node.right;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }
    
}
