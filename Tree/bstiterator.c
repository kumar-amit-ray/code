/*
https://leetcode.com/problems/binary-search-tree-iterator/description/> 

Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

 	  7
         / \
        3   15
            /\  
           9  20

BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false

next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.
*/

/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
struct BSTIterator {
    struct TreeNode *stack[10000];
    int top;
};

void bstIterate(struct BSTIterator *iter, struct TreeNode *root) {
    struct TreeNode *start;
    
    start = root;
    while (start) {
        iter->top++;
        iter->stack[iter->top] = start;
        start = start->left;
    }
}
struct BSTIterator *bstIteratorCreate(struct TreeNode *root) {
    struct BSTIterator *iter;
    
    iter = calloc(1, sizeof(struct BSTIterator));
    iter->top = -1;
    
    bstIterate(iter, root);
    return iter;
}

/** @return whether we have a next smallest number */
bool bstIteratorHasNext(struct BSTIterator *iter) {
    return (iter->top == -1)?false:true;
}

/** @return the next smallest number */
int bstIteratorNext(struct BSTIterator *iter) {
    struct TreeNode *node;
    
    node = iter->stack[iter->top];
    iter->top--;
    if (node->right) {
        bstIterate(iter, node->right);
    }
    return node->val;
}

/** Deallocates memory previously allocated for the iterator */
void bstIteratorFree(struct BSTIterator *iter) {
    free(iter);
}

/**
 * Your BSTIterator will be called like this:
 * struct BSTIterator *i = bstIteratorCreate(root);
 * while (bstIteratorHasNext(i)) printf("%d\n", bstIteratorNext(i));
 * bstIteratorFree(i);
 */

In Python
---------
class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.root = root
        self.stack = list()
        self.iterate_stack(self.root)

    def iterate_stack(self, root):
        left_subtree = root
        while left_subtree is not None:
            self.stack.append(left_subtree)
            left_subtree = left_subtree.left

    def next(self):
        """
        @return the next smallest number
        :rtype: int
        """
        elem = self.stack.pop()
        if elem.right is not None:
            self.iterate_stack(elem.right)

        return elem.val

    def hasNext(self):
        """
        @return whether we have a next smallest number
        :rtype: bool
        """
        if len(self.stack) == 0:
            return False
        else:
            return True
