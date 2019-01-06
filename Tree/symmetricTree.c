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
