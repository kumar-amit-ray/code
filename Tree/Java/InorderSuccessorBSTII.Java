/**
    Given a node in a binary search tree, return the in-order successor of that node in the BST. If that node has no in-order successor, return null.

The successor of a node is the node with the smallest key greater than node.val.

You will have direct access to the node but not to the root of the tree. Each node will have a reference to its parent node. Below is the definition for Node:

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}

@Leetcode - https://leetcode.com/problems/inorder-successor-in-bst-ii/
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        if (node == null) {
            return null;
        }
        
        // if the node has right subtree, find the inoder successer is the left most child of the right subtree.
        if (node.right != null) {
            Node temp = node.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }
        
        if (node.parent == null) {
            // if node does not have a parent, then it does not have a inorder successor.
            return null;
        } else if (node == node.parent.left) {
            // if node is the left child of its parent then the parent is the inorder successor
            return node.parent;
        } else {
            // if the node is the right child of its parent, then keep going up to find a parent where node 
            // exist in the left subtree. 
            Node temp = node;
            while (temp.parent != null) {
                if (temp == temp.parent.right) {
                    temp = temp.parent;
                } else {
                    return temp.parent;
                }
            }
        }
        return null;
    }
}
