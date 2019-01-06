/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
int findSecondMinHelper(struct TreeNode* root) {
    int smin;
    if (root == NULL) return -1;
    if (!root->left && !root->right) {return -1;}
    smin = findSecondMinimumValue(root);
    if (smin == root->val) return -1;
    
    return smin;
}

int findSecondMinimumValue(struct TreeNode* root) {
    int smin;
    
    if (root == NULL || !root->left) {return -1;}
    if (root->val == root->left->val) {
        // root is from left subtree
        smin =  findSecondMinimumValue(root->left);
        if (smin == -1 || smin > root->right->val) {return root->right->val;}
        else {return smin;}
    } else {
        smin =  findSecondMinimumValue(root->right);
        if (smin == -1 || smin > root->left->val) {return root->left->val;}
        else {return smin;}
    }
}
