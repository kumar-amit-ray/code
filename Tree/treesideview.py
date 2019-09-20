'''
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
'''
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def __init__(self):
        self.min = 0
        self.max = 0
        
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        result = list()
        if root is None: return result
        level_track = dict()
        self.rightSideView_recursive(root, 0, level_track)
        print self.min, self.max
        result = list()
        i= self.min
        while i<=self.max:
            result.append(level_track[i])
            i +=1
        
        return result
    
    def rightSideView_recursive(self, node, level, level_track):
        if node is None: return
        if level not in level_track:
            level_track[level] = node.val
        
        if level < self.min: self.min = level
        elif level > self.max: self.max = level
            
        self.rightSideView_recursive(node.right, level+1, level_track)
        self.rightSideView_recursive(node.left, level+1, level_track)
