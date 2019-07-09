/*
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
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
bool checkSymmetric(struct TreeNode* lefttree, struct TreeNode* righttree) {
    if (lefttree->val != righttree->val) {return false;}
    if (lefttree->left && !righttree->right) {return false;}
    if (!lefttree->left && righttree->right) {return false;}    
    if (lefttree->right && !righttree->left) {return false;}
    if (!lefttree->right && righttree->left) {return false;}
        
    return true;
}
bool isSymmetric1(struct TreeNode* left, struct TreeNode* right) {
    bool nextlevel;
    if (checkSymmetric(left, right) == false) {return false;}
    if (left->left) {
        nextlevel = isSymmetric1(left->left, right->right);
    }
    if (nextlevel == true && left->right) {
        nextlevel = isSymmetric1(left->right, right->left);
    }
    return nextlevel;
}

bool isSymmetric(struct TreeNode* root) {
    if (root == NULL) {return true;}
    if (root->left == NULL && root->right== NULL) {return true;}
    if (root->left && root->right) {
        return isSymmetric1(root->left, root->right);
    }
    return false;
}

In Python
==========
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root is None:
            return True
        if root.left is None and root.right is None:
            return True
        if root.left is not None and root.right is not None:
            return self.isSymmetric_internal(root.left, root.right)
        return False
    
    def isSymmetric_internal(self, lt, rt):
        if lt.val != rt.val:
            return False
        if lt.right is None and rt.left is not None:
            return False
        if lt.right is not None and rt.left is None:
            return False
        if lt.left is None and rt.right is not None:
            return False
        if lt.left is not None and rt.right is None:
            return False
        if lt.left:
            result = self.isSymmetric_internal(lt.left, rt.right)
            if result is False:
                return False
        if lt.right:
            result = self.isSymmetric_internal(lt.right, rt.left)
            if result is False:
                return False
        
        return True
            
