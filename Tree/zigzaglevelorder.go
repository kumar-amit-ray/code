/*
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
*/

// NOTE - This code has problem that map does not preserve order or levels, so the output can come in any 
// order. E.g. for above example output can [[15,7],[20,9],[3]]. So, we need to use a 2D slice as is for storing
// output instead of a temporary map


/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
    def zigzagLevelOrder(self, root):
        order = list()
        self.zigzagLevelOrderWithLevel(root, 0, order)
        return order

    """
    This problem can be solved by two stacks also- https://www.youtube.com/watch?v=vjt5Y6-1KsQ
    In this algo, we applied a simple concept of append and insert to solve the problem.
    - The way we process each level is same.
    - At each level left child is process first and right child is processed next. 
    - The difference is how we put that in the list. 
    - As per the problem, at each odd level, it should be right to left. and each even level it should be left to right. 
    - So, as our simple order is left to right, at each odd level we just reverse the list append and make it an insert.
    """

    def zigzagLevelOrderWithLevel(self, node, level, order):
        if node is None:
            return

        if len(order) > level:
            if level % 2 != 0:
                order[level].insert(0, node.val)
            else:
                order[level].append(node.val)
        else:
            level_list = list()
            level_list.append(node.val)
            order.append(level_list)

        self.zigzagLevelOrderWithLevel(node.left, level + 1, order)
        self.zigzagLevelOrderWithLevel(node.right, level + 1, order)
